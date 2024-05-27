package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17836 {
    static int[][] map;
    static boolean[][][] visited;
    static int n,m,s;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Queue<Point> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][2];//검을 갖는 순간부터 방문배열 dif <- 검찾은 순간 뒤로 가서 다시 부술 수 있으니

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(sb);

    }

    static void bfs() {
        q.offer(new Point(0,0, s, false));
        while (!q.isEmpty()) {
             Point p = q.poll();
             if (p.s < 0) {
                break;
             }
             if (p.x == n-1 && p.y == m-1) {
                 sb.append(s-p.s);
                 return;
             }
             for (int i = 0; i < 4; i++) {
                 int nx = p.x + dx[i];
                 int ny = p.y + dy[i];
                 if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                 if (p.obtained) {
                     if (visited[nx][ny][1]) continue;
                     if (map[nx][ny] == 1) {//무기 있을 때 벽을 만나면
                         q.offer(new Point(nx,ny, p.s-1, true));
                     } else { // 무기 있을 때 도로라면
                         q.offer(new Point(nx,ny, p.s-1, true));
                     }
                     visited[nx][ny][1] = true;
                 } else {// 무기 없다면
                     if (visited[nx][ny][0]) continue;
                     if (map[nx][ny] == 1) continue;//무기 없을 때 벽을 만나면 continue
                     if (map[nx][ny] == 2) {
                         q.offer(new Point(nx,ny, p.s-1, true));
                     } else {
                         q.offer(new Point(nx,ny, p.s-1, false));
                      }
                     visited[nx][ny][0] = true;

                 }
             }
        }
        sb.append("Fail");

    }

    static class Point {
        int x;
        int y;
        int s;
        boolean obtained;

        private Point(int x, int y, int s, boolean obtained) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.obtained = obtained;

        }
    }
}
