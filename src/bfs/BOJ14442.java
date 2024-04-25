package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14442 {
    static int n;
    static int m;
    static int chance;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chance = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[chance+1][n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        if (n == 1 && m == 1){ System.out.println(1); return;}

        ///////////초기화 완료
        bw.write(bfs() + "\n");
        bw.flush();
    }
    static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0,chance, 1));//찬스와 거리가 추가된다,
        visited[chance][0][0] = true;//chance개수마다 visited다르다
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == n-1 && p.y == m-1) return p.dist;


            int chance = p.getChance();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                //1. 범위 벗어나거나 2. 방문한곳이라면 넘어간다.
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[chance][nx][ny]) continue;

                //만약 벽이라면, 1. 찬스남아있어야 하고 2. 찬스하나 더쓴 상황에서 방문한 적이 없어야 한다.
                if (map[nx][ny] == 1 && chance>0 && visited[chance-1][nx][ny] == false) {
                        q.offer(new Point(nx, ny, chance-1, p.dist+1));
                        visited[chance-1][nx][ny] = true;
                } else if (map[nx][ny] == 0){//벽이 아니라면
                    q.offer(new Point(nx, ny, p.chance, p.dist+1));
                    visited[chance][nx][ny] = true;
                }
            }

//방문처리를 벽부서지는 것에 따로 해야함. 라운드에 따라?

        }
        return -1;
    }

    static class Point {
        int x;
        int y;
        int chance;
        int dist;
        private Point(int x, int y, int chance, int dist) {
            this.x = x;
            this.y = y;
            this.chance = chance;
            this.dist = dist;
        }
        private int getChance() {
            return this.chance;
        }
    }
}
