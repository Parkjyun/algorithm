package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18405 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Point> pq = new PriorityQueue<>();
    static int n;
    static int x,y,s;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if (a != 0) {
                    visited[i][j] = true;
                    pq.offer(new Point(i,j,a));
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
         x = Integer.parseInt(st.nextToken());
         y = Integer.parseInt(st.nextToken());
         if (s == 0){
             System.out.println(map[x][y]);
             return;
         }

        bfs();
        System.out.println(sb);
    }

    static private void bfs() {
        Queue<Point> q = new LinkedList<>();
        int bs = 0;
        while (!pq.isEmpty()) {
            bs++;
            int size = pq.size();
            //System.out.println(size);
            for (int i = 0; i < size; i++) {
                q.offer(pq.poll());
            }
            for (int i = 0; i < size; i++) {
                Point p = q.poll();
                //System.out.println(p.x + ","+ p.y);
                for (int a = 0; a < 4; a++) {
                    int nx = p.x + dx[a];
                    int ny = p.y + dy[a];
                    if (nx < 1 || nx > n || ny < 1 || ny > n || visited[nx][ny]) continue;
                    map[nx][ny] = p.val;
                    pq.offer(new Point(nx, ny, p.val));
                    visited[nx][ny] = true;
                }
            }
            if (bs == s) {
                System.out.println(map[x][y]);
                return;
            }
            }
        System.out.println(map[x][y]);

        }

    static class Point implements Comparable<Point>{//priority queue에 val 작은 것이 우선 시됨
        int x;
        int y;
        int val;
        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Point o) {
            return this.val - o.val;//민약 this.val = 5, o.val = 8 -> 음수 this가 아ㅠ에 -> 우선순위가 높다 -> 작을수록 높다
        }
    }

}
