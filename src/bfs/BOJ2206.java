package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2206 {
    static int n;
    static int m;
    static char[][] map;
    static int[][][] dist;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        if(n-1 == 0 && n-1 == 0){
            System.out.print(1);
            System.exit(0);
        }
        map = new char[n][m];
        dist = new int[n][m][2];
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        queue.offer(new Point(0,0, false));
        System.out.println(bfs());

    }
    static int bfs() {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny] == '1') {//벽일때
                    if(p.chance == false && dist[nx][ny][1] == 0) {//찬스 사용한 적이 없고 다음 후보가 방문하지 않은 곳이라면
                        dist[nx][ny][1] = dist[p.x][p.y][0] + 1;//하나 표시해준다
                        queue.offer(new Point(nx, ny, true));
                    } else continue;
                } else {//벽이아니면
                    if(p.chance == true && dist[nx][ny][1] == 0) { // 찬스썻고 다음 후보가 방문하지 않은 곳이라면
                    dist[nx][ny][1] = dist[p.x][p.y][1] + 1;
                    queue.offer(new Point(nx, ny, true));
                    } else if(p.chance == false && dist[nx][ny][0] == 0) {// 찬스써본적 없고 다음 후보가 방문하지 않은 곳이라면
                        dist[nx][ny][0] = dist[p.x][p.y][0] + 1;
                        queue.offer(new Point(nx, ny, false));
                    }
                }
            }
        }
        if(dist[n-1][m-1][0] == 0 && dist[n-1][m-1][1] == 0) return -1;//벽을 뚫은 경우와 벽을 뚫지 않은 경우 모두 0이라면 -1을 return
        else if(dist[n-1][m-1][0] == 0) return dist[n-1][m-1][1] + 1;
        else if(dist[n-1][m-1][1] == 0) return dist[n-1][m-1][0] + 1;
        else return Math.min(dist[n-1][m-1][1] + 1,dist[n-1][m-1][0] + 1);

    }

    static class Point {
        int x;
        int y;
        boolean chance;
        Point(int x, int y, boolean chance) {
            this.x = x;
            this.y = y;
            this.chance = chance;
        }
    }
}
