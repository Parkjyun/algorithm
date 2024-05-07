package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3187 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        //#은 울타리
        // v = 늑대 k = 앵
        // 양의 숫자가 늑대보다 많을 경우 늑대가 잡아 먹힘
        //양과 늑대의 수를 넣어라
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '#') visited[i][j] = true;
            }
        }

        bfs();
        System.out.println(sb);

    }
    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        int sums=0;
        int sumw=0;
        int w;
        int s;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (!visited[a][b] && map[a][b]!= '#') {//방문하지 않았고 벽이 아니라면
                    w = 0;
                    s = 0;
                    q.offer(new Point(a, b));
                    visited[a][b] = true;
                    while (!q.isEmpty()) {
                        Point p = q.poll();
                        if (map[p.x][p.y] == 'v') w++;
                        if (map[p.x][p.y] == 'k') s++;
                        for (int i = 0; i < 4; i++) {
                            int nx = p.x + dx[i];
                            int ny = p.y + dy[i];
                            //범위 벗어나고 방문했다면 continue
                            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;
                            //벽이라면 continue
                            if (map[nx][ny] == '#') continue;
                            q.offer(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                    if (s>w) sums += s;
                    if (w>=s) sumw +=w;
                }
            }
        }
        sb.append(sums + " " + sumw);
    }
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
