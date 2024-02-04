package bfs;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0 ,-1};
    static Point start;
    static int n;
    static int m;
    static Queue<Point> queue = new LinkedList<>();
    static Queue<Point> fireQueue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m;j++) {
                char temp = line.charAt(j);
                if(temp == 'J')
                    start = new Point(i,j,0);
                if(temp == 'F') {
                    fireQueue.offer(new Point(i,j));
                }
                map[i][j] = temp;
            }
        }
        int res = bfs();
        if(res == -1)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(res);
    }
    static int bfs() {
        queue.offer(start);
        visited[start.x][start.y] = true;
        int x = 0;
        int y = 0;
        int curTime = 0;

        while (!queue.isEmpty()) {//사람큐가 비어있지 않다면
            Point p = queue.poll();//하나꺼내
            //시작하자마자 탈출할 수 있다면 바로 탈출
            if (p.x == 0 || p.y == 0 || p.x == n-1 || p.y == m-1) {
                return 1;
            }
            //사람의 시간대보다 불의 시간대가 작거나 같다면(불먼저이동한다 가정) 불 1회 탐색
            if (p.t >= curTime){
                int fSize = fireQueue.size();
                for(int s=0; s < fSize; s++) {//각 방향으로 1회 탐색만 하기 위해 이전에 큐에 들어온 사이즈 만큼만 탐색
                    Point fp = fireQueue.poll();
                    for (int i = 0; i < 4; i++) {
                        int nfx = fp.x + dx[i];
                        int nfy = fp.y + dy[i];
                        //1. 범위 나가고 2. 벽이고 3. 방문한 곳이라면(이미 지난 곳은 안해도 됨) continue
                        if (nfx < 0 || nfy < 0 || nfx >= n || nfy >= m || visited[nfx][nfy] || map[nfx][nfy] == '#') continue;

                        fireQueue.offer(new Point(nfx, nfy));//불 전용 큐에 넣고
                        visited[nfx][nfy] = true;//어차피 불이 나면 방문하지 못한다. 걍 방문 처리 해주자
                    }
                }
                curTime++;//불의 시간대 하나 이동했으니 하나 ++
            }
            //사람이동
            for (int i = 0; i < 4; i++) {
                x = p.x + dx[i];
                y = p.y + dy[i];
                //1. 범위 벗어나거나 2. 방문한것이거나 3. 벽이거나 4. 불이라면 continue
                if(x < 0 || y < 0 || x >= n || y>= m || visited[x][y] || map[x][y] == '#' || map[x][y] == 'F') continue;
                queue.offer(new Point(x,y, p.t+1));//t+1은 이동 후의 시간
                visited[x][y] = true;
                //1. 경계면이고 2. .이라면
                if((x == 0 || y == 0 || x == n-1 || y == m-1) && map[x][y] == '.' ) {
                    return p.t+2;//t+1은 벽에서의 시간, 벽에서 1초 더 지나야 탈출임
                }
            }
        }
        return -1;//실패시 걍 -1 반환(분기 처리용)
    }
    static class Point {
        int x;
        int y;
        int t;
        public Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
