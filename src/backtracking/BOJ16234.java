package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16234 {
    static boolean[][] visited;
    static int[][] map;
    static List<Point> u;
    static int n, l, r;
    static boolean stop = false;
    static int count = 0;
    static int[] dx =  {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int uC = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (stop) break;
            uC = 0;
            visited = new boolean[n][n];
            stop = true;
            count++;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    //한지점에서 연합만들기 시작
                    if (visited[i][j]) continue;
                    u = new LinkedList<>();
                    visited[i][j] = true;
                    u.add(new Point(i,j));
                    dfs(i,j);
                    if (u.size() == 1){// 혼자라 이동 필요없다면 ㅂㅂ
                        continue;
                    }
                    int sum = 0;
                    for (int a = 0; a < u.size(); a++) {
                        Point point = u.get(a);
                        sum += map[point.x][point.y];
                    }
                    for (int a = 0; a < u.size(); a++) {
                        Point point = u.get(a);
                        map[point.x][point.y] = sum / u.size();
                    }
                }
            }
        }


        System.out.println(count-1);
    }

    static void dfs(int x, int y) {


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx <  0 || ny < 0 || nx >= n || ny >= n) continue;
            if (visited[nx][ny]) continue;

            if (Math.abs(map[x][y] - map[nx][ny]) >= l && Math.abs(map[x][y] - map[nx][ny]) <= r) {
                u.add(new Point(nx,ny));
                stop = false;
                visited[nx][ny] = true;
                dfs(nx, ny);
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
