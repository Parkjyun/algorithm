package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562 {
    static int[][] map;
    static boolean[][] visited;
    static int t, n;
    static int count;
    static Point start, end;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        t =Integer.parseInt(br.readLine());//총 횟수3
        for(int i = 0; i < t; i++) {
            count = 0;
            n = Integer.parseInt(br.readLine());//
            map = new int[n][n];
            visited = new boolean[n][n];
            st = new StringTokenizer(br.readLine());

            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            bfs();
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.getX()][start.getY()] = true;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if(p.getX() == end.getX() && p.getY() == end.getY()) {
                sb.append(p.count+ "\n");
            }

            for (int i = 0; i < 8; i++) {
                int x = p.getX() + dx[i];
                int y = p.getY() + dy[i];
                if(x < 0 || y < 0 || x >= n || y >= n)//범위밖이면 나가라
                    continue;
                if(!visited[x][y]) {//방문하지 않은 곳이라면 하나 넣고 카운트 올리고 방문표
                    visited[x][y] = true;
                    queue.offer(new Point(x,y, p.count+1));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int count;
        private Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
