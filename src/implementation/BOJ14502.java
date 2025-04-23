package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static int n,m, max;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();
    static List<Point> safe = new LinkedList<>();
    static Point[] comb = new Point[3];
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    q.add(new Point(i,j));
                    visited[i][j]= true;
                }
                if (map[i][j] == 0) {
                    safe.add(new Point(i,j));
                }

            }
        }
        max = Integer.MIN_VALUE;

        dfs(0, 0);


        System.out.println(max);


    }

    static int bfs(Queue<Point> q, int[][] map) {
        visited = new boolean[n][m];


        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >=n || ny >= m) continue;
                if (map[nx][ny] == 1 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                map[nx][ny] = 2;
                q.offer(new Point(nx, ny));
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }

    static void dfs(int depth, int start) {

        if (depth == 3) {
            count++;
            int tempMap[][] = new int[n][m]; // 이번 조합 벽이 들어갈 애들 // bfsq 이번 조합 애들이 bFs에서 쓸 큐
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tempMap[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < 3; i++) {
                Point newB = comb[i];
                tempMap[newB.x][newB.y] = 1;
            }
            Queue<Point> bfsq = new LinkedList<>(q);
            max = Math.max(bfs(bfsq, tempMap), max);
            return;
        }
        for (int i = start; i < safe.size(); i++) {
            comb[depth] = safe.get(i);
            dfs(depth+1, i+1);

        }
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}
