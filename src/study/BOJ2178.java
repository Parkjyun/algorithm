package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(Character.toString(s.charAt(j)));
            }
        }
        System.out.println(bfs());
    }
    private static int bfs() {
        q.offer(new Point(0,0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                //1. 범위 벗어나거나 2. 이미 방문한 곳이거나 3. 갈 수 없는 길이라면     아무것도 하지 않는다.
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 0) continue;
                q.offer(new Point(nx,ny));
                map[nx][ny] = map[p.x][p.y] + 1;
                visited[nx][ny] = true;
            }
        }
        return map[n-1][m-1];
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
