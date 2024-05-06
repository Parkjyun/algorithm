package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1189 {
    static int n;
    static int m;
    static int k;
    static char[][] map;
    static boolean[][] visited;
    static int count;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        visited[n-1][0] = true;
        System.out.println(backtracking(new Point(n-1,0,1)));
    }
    static int backtracking(Point p) {
        if (p.depth == k) {
            if (p.x == 0 && p.y == m-1)
                count++;
            return count;
        }
        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m
                    || visited[nx][ny] || map[nx][ny] == 'T'  ) continue; // 범위 나간다면 continue;
            visited[nx][ny] = true;
            //System.out.println(nx + "," + ny);
            backtracking(new Point(nx, ny, p.depth + 1));
            visited[nx][ny] = false;
        }
        return count;

    }

    static class Point {
        int x;
        int y;
        int depth;
        Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
