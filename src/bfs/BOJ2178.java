package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int n;
    static int m;
    static int[][] map;
    static int[][] dist;
    static int count = 0;
    static Queue<Point> queue;
    static boolean[][] visited;
    static int dX[] = {0, 1, 0, -1};
    static int dY[] = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        dist = new int[n + 1][m + 1];
        visited = new boolean[n+1][m+1];
        queue = new LinkedList<>();

        for (int i = 1; i < map.length; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = Character.getNumericValue(ch[j-1]);
            }
        }
        dist[1][1] = 1;
        bfs();
        System.out.println(dist[n][m]);
    }

    static void bfs() {
        queue.offer(new Point(1, 1));//1을 넣고

        while (!queue.isEmpty()) {//q가 비어있지 않다면
            Point p = queue.poll();//값
            for (int i = 0; i < 4; i++) {//현재위치 기준 동서남북에서
                int nx = p.x + dX[i];
                int ny = p.y + dY[i];
                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;//범위를 빠져나가면 패스
                if (visited[nx][ny] || map[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                dist[nx][ny] = dist[p.x][p.y] + 1;
                queue.offer(new Point(nx, ny));//큐에 넣는다

            }
        }

    }


    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


