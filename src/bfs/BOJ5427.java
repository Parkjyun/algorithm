package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5427 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0 ,-1};
    static char[][] map;
    static boolean[][] visited;
    static Point start;
    static StringBuilder sb = new StringBuilder();
    static Queue<Point> queue;
    static Queue<Point> fireQueue;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            queue = new LinkedList<>();
            fireQueue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            map = new char[n][m];
            visited = new boolean[n][m];
            for (int a = 0; a < n; a++) {
                String temp = br.readLine();
                for (int b = 0; b < m; b++) {
                    char c = temp.charAt(b);
                    if (c == '@')
                        start = new Point(a, b, 0);
                    else if (c == '*')
                        fireQueue.offer(new Point(a, b, 0));

                    map[a][b] = c;
                }
            }
            sb.append(bfs());
        }
        System.out.println(sb);
    }
    static String bfs() {
        queue.offer(start);
        visited[start.x][start.y] = true;
        int curTime = 0;//사실상 불의 시간
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if ((p.x == n-1 || p.x == 0 || p.y == m-1 || p.y == 0) && (map[p.x][p.y] == '@'))
                return new String(p.t + 1+ "\n");
            //불에 대한 bfs 만약 빼온 Point 가 cuRtime보다 시간이 크다면 불에 대한 bfs를 1회 실행
            if(p.t >= curTime) {
                curTime++;
                int fireQueueSize = fireQueue.size();//1초에 bfs를 실행할 때 얼만큼의 point를 탐색해야 하는가? -> 직전 초에 추가된 불들만
                for (int i = 0; i < fireQueueSize; i++) {
                    Point fP = fireQueue.poll();
                    for (int j = 0; j < 4; j++) {
                        int nfx = fP.x + dx[j];
                        int nfy = fP.y + dy[j];
                        //효율적인 메모리 사용을 위해 방문한 곳에는 불이 안 옮겨가도록 처리 -> 어차피 이미 사람이 지나간 자리 -> 불이 지나가도 늦음
                        if (nfx < 0 || nfy < 0 || nfx >= n || nfy >= m || map[nfx][nfy] == '#' || visited[nfx][nfy]) continue;
                        map[nfx][nfy] = '*';
                        visited[nfx][nfy] = true;
                        fireQueue.offer(new Point(nfx,nfy,curTime));
                    }
                }

            }
            //사람에 대한 bfs실행
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == '*' || map[nx][ny] == '#') continue;
                visited[nx][ny] = true;
                queue.offer(new Point(nx, ny, p.t+1));
                if ((nx == 0 || ny == 0 || nx == n-1 || ny == m-1) &&map[nx][ny] == '.')
                    return p.t+2 + "\n";
            }
        }
        //while문을 다 돌았는데 못 나간다
        return "IMPOSSIBLE\n";
    }

    static class Point {
        int x;
        int y;
        int t;

        private Point (int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

}
