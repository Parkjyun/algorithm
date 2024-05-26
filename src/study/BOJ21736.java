package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21736 {
    static char map[][];
    static boolean visited[][];
    static int n;
    static int m;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int count = 0;
    static Queue<Point> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
                if (c == 'I') q.offer(new Point(i,j));
            }
        }
        bfs();
        System.out.println(sb);

    }

    static void bfs() {
        while (!q.isEmpty()) {
            Point p = q.poll();

            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 'X') continue;
                if (map[nx][ny] == 'P') count++;
                q.offer(new Point(nx,ny));
                visited[nx][ny] = true;
            }
        }
        if (count == 0) sb.append("TT");
        else sb.append(count);
    }

    static class Point {
        int x;
        int y;
        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
