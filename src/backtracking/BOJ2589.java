package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589 {
    static int[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n,m;
    static int[][] map;
    static int max = Integer.MIN_VALUE; // 최단 거리의 최대
    public static void main(String[] args) throws IOException {
        //육지 l과 바다 w
        // 보물은 육지에서 가장 먼곳 두곳에 존재
        // 보물 사이의 거리는?
        // -> 모든 최단거리간 max값은?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    max = Math.max(bfs(i, j), max);
                }
            }
        }
        System.out.println(max-1);
    }

    static int bfs(int x, int y) {//최단거리중 최대를 반환한다.
        visited = new int[n][m];
        int max = Integer.MIN_VALUE;
        Queue<Point> q = new LinkedList<>();
        visited[x][y] +=1;
        q.offer(new Point(x,y));

        while(!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == 'W') continue;
                if (visited[nx][ny] > 0) continue;//방문했다면 가지 않는다.

                visited[nx][ny] = visited[p.x][p.y]  + 1;
                max = Math.max(max, visited[nx][ny]);
                q.offer(new Point(nx, ny));
            }
        }
        return max;

    }

    static class Point {
        int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
