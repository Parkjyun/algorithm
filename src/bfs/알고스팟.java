package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 알고스팟 {
    static boolean visited[][];
    static int map[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs());



    }

    static int bfs() {
        Point start = new Point(0, 0, 0);
        PriorityQueue<Point> q = new PriorityQueue<>((a, b) -> a.w - b.w);//w작은 것 부터
        q.offer(start);
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == n-1 && p.y == m-1) {
              return p.w;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;
                if (map[nx][ny] == 1) {//벽이라면
                    q.offer(new Point(nx, ny, p.w+1));
                } else {
                    q.offer(new Point(nx, ny, p.w));
                }
                visited[nx][ny] = true;

            }
        }
        return 0;
    }

    static class Point {
        int x, y, w;
        Point(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
}
