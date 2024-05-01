package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14716 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0,1,1,1,0,-1,-1,-1};
    private static int[] dy = {1,1,0,-1,-1,-1,0,1};
    private static int n;
    private static int m;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(sb);
    }
    private static void bfs() {

        Queue<Point> q = new LinkedList<>();
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    q.offer(new Point(i, j));
                    visited[i][j] = true;
                    count++;
                    while (!q.isEmpty()) {
                        Point p = q.poll();
                        int nx;
                        int ny;
                        for (int a = 0; a < 8; a++) {
                            nx = p.x + dx[a];
                            ny = p.y + dy[a];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 0) continue;
                            q.offer(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        sb.append(count);


    }

    static class Point {
        int x;
        int y;

        private Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}
