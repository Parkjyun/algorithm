package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576RE {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Queue<Point> q = new LinkedList<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new Point(i,j));//돌면서 익은 애들 큐에 넣고
                    visited[i][j] = true;//방문 표시
                }
            }
        }
        System.out.println(bfs());
    }
    //1-> 익은 토마토    0 -> 익지 않은 토마토  -1 -> 토마토가 없는 칸
    //매일 상하좌우 익은 토마토가 익어짐 -> 최종 걸리는 날은?
    static int bfs() {
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                //1. 범위를 벗어나고 이미 방문한 곳이고 빈칸이라면 아무것도 하지 않는다.
                if (nx < 0 || ny < 0 || nx >=n || ny >= m || visited[nx][ny] || map[nx][ny] == -1) continue;
                q.offer(new Point(nx, ny));
                map[nx][ny] = map[p.x][p.y] + 1;
                visited[nx][ny] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) return -1;
                if (map[i][j] > max) max = map[i][j];
            }
        }
        return max-1;
    }

    static class Point {
        int x;
        int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
