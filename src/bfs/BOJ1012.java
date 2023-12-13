package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1012 {
    static int m ,n, no;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int answer;

    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            no = sc.nextInt();

            map = new int[m][n];
            visited = new boolean[m][n];

            for(int j = 0; j < no; j++) {
                int x = sc.nextInt();
                int y= sc.nextInt();
                map[x][y] = 1;
            }
            //첫번째 loop 초기화 완료
            bfs();
            System.out.println(answer);
        }
    }
    static void bfs() {//이어진 놈들끼리의 숫자를 구해야 한다. 즉 시드가 들어오면 count++;
        answer = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) { // map의 모든 요소를 돌아다니면서
                if(visited[i][j] || map[i][j] == 0) continue; //방문했거나 무가 없다면 넘어간다.

                queue.offer(new Point(i,j));
                visited[i][j] = true;
                answer++;

                while(!queue.isEmpty()) {
                    Point p = queue.poll();
                    for(int l = 0; l < 4; l++) {
                        int nx;
                        int ny;
                        nx = p.x + dx[l];
                        ny = p.y + dy[l];
                        if(nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) continue;
                        if(map[nx][ny] == 1) {
                            visited[nx][ny] = true;
                            queue.offer(new Point(nx, ny));
                        }
                    }
                }
            }
        }

    }
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
