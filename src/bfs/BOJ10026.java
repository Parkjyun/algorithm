package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//색약은 rg를 같은 색으로 인식
public class BOJ10026 {
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point> queue;
    static int nC = 0;
    static int jC = 0;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        n = Integer.parseInt(str);//5
        map = new char[n+1][n+1];
        visited = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {//5QJS
            str = br.readLine();
            for(int j = 1; j < n+1; j++)
                map[i][j] = str.charAt(j-1);

        }

        queue = new LinkedList<>();
        bfs();
        jbfs();
        sb.append(nC + " " + jC);
        System.out.println(sb);
    }

    static void bfs() {
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                if(visited[i][j] == true) continue;//방문했던 곳이면 넘어가

                queue.offer(new Point(i,j));//방문하지 않았던 곳이라면 시드 넣어주고
                nC++;//숫자를 올려
                while(!queue.isEmpty()) {//넣어준 시드에 대해서 큐가 빌때까지
                    Point p = queue.poll();//시드를 빼고
                    for(int l = 0; l < 4; l++) {//그 시드애 대한 동서남북 진행
                        int nx = p.x + dx[l];
                        int ny = p.y + dy[l];
                        if(nx < 1 || ny < 1 || nx > n || ny > n) continue;//새것이 범위 벗어나면 continue
                        if(visited[nx][ny] || map[nx][ny] != map[p.x][p.y]) continue; // 새것이 이미 방문이거나 색이 다르다면 Continnue
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }

            }
        }
    }

    static void jbfs() {
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                if(map[i][j] == 'G') map[i][j] = 'R';
                visited[i][j] = false;
            }
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                if(visited[i][j] == true) continue;//방문했던 곳이면 넘어가
                queue.offer(new Point(i,j));//방문하지 않았던 곳이라면 시드 넣어주고
                jC++;//숫자를 올려
                while(!queue.isEmpty()) {//넣어준 시드에 대해서 큐가 빌때까지
                    Point p = queue.poll();//시드를 빼고
                    for(int l = 0; l < 4; l++) {//그 시드애 대한 동서남북 진행
                        int nx = p.x + dx[l];
                        int ny = p.y + dy[l];
                        if(nx < 1 || ny < 1 || nx > n || ny > n) continue;//새것이 범위 벗어나면 continue
                        if(visited[nx][ny] || map[nx][ny] != map[p.x][p.y]) continue; // 새것이 이미 방문이거나 색이 다르다면 Continnue
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }

            }
        }
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
