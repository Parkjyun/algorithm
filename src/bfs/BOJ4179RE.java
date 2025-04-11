package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179RE {
    static int n, m;
    static char[][] map;
    static int[][] visitedF;
    static int[][] visitedP;
    static int[][] fire;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int answer = 0;
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        fire = new int[n][m];
        visitedF = new int[n][m];
        visitedP = new int[n][m];

        Point p = null;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'F') {
                    visitedF[i][j] = 1;
                    q.offer(new Point(i,j));
                }
                if (map[i][j] == 'J') {
                    p = new Point(i,j);
                }
            }
        }


        bfsF();

        bfs(p);

        if (answer == 0) {
            System.out.println("IMPOSSIBLE");
        } else
            System.out.println(answer);
    }
    static void bfs(Point p) {

        Queue<Point> q = new LinkedList<>();

        visitedP[p.x][p.y] = 1;
        q.offer(p);

        while (!q.isEmpty()) {
            Point poll = q.poll();
            if (poll.x == n-1 || poll.y == m-1 || poll.x == 0 || poll.y == 0) {
                answer = visitedP[poll.x][poll.y];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (out(nx,ny)) continue;//범위
                if (map[nx][ny] == '#') continue;//벽
                if (visitedP[nx][ny] > 0) continue;//사람 방문 무시
                if (visitedP[poll.x][poll.y] + 1 >= visitedF[nx][ny] && visitedF[nx][ny] != 0) continue; // 불 있는 곳 못간다.
                visitedP[nx][ny] = visitedP[poll.x][poll.y] + 1;
                q.offer(new Point(nx,ny));
            }

        }

    }

    static void bfsF() {
        while (!q.isEmpty()) {
            Point poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (out(nx,ny)) continue;//범위
                if (map[nx][ny] == '#') continue;//벽
                if (visitedF[nx][ny] > 0) continue;//사람 방문 무시
                visitedF[nx][ny] = visitedF[poll.x][poll.y] + 1;
                q.offer(new Point(nx,ny));
            }
        }

    }
    static boolean out(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m) return true;
        return false;
    }
    static class Point {
        int x,y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
