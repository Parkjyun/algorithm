package programmers.dp;

import java.util.*;

public class 경주로건설  {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};

    public int solution(int[][] board) {
        int[][][] dist = new int[board.length][board.length][4]; // 마지막은 온 방향
        for (int[][] sm : dist) {
            for (int[] l : sm) {
                Arrays.fill(l, Integer.MAX_VALUE);
            }
        }
        Queue<Point> q = new LinkedList<>();

        // 1. 방향은 온 방향 이외의 세방향으로 뻗어간다.
        // 이때 oor || 이번 new val < 이전 모든 4way dist val -> 이래야 작은 것 들어가서 유의미한 최솟값 들어가지. 언제 끝? 큐가 empty면
        // 직진이라면 + 100 방향 바꾸면 + 600
        // 2. n-1 4way중 최소

        if (board[1][0] == 0) {
            q.offer(new Point(1,0,1));
            dist[1][0][1] = 100;
        }
        if (board[0][1] == 0) {
            q.offer(new Point(0,1,0));
            dist[0][1][0] = 100;
        }
        while (!q.isEmpty()) {
            Point p  = q.poll();

            for (int i = 0; i < 4; i++) { // 향하는 방향
                if (p.d - i == 2 || p.d - i == -2) continue;                        //이전 방향
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                // oor
                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length || board[nx][ny] == 1) continue;
                // val
                //직진
                if (p.d == i) {                                                     //직진
                    int nv = dist[p.x][p.y][p.d] + 100;

                    if (nv <= dist[nx][ny][p.d]) {
                        q.offer(new Point(nx,ny, i));
                        dist[nx][ny][i] = nv;
                    }


                } else {                                                            //좌우
                    int nv = dist[p.x][p.y][p.d] + 600;
                    if (nv <= dist[nx][ny][i]) {
                        q.offer(new Point(nx,ny, i));
                        dist[nx][ny][i] = nv;
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int price : dist[board.length-1][board.length-1]) {
            System.out.println(price);

            answer = Math.min(answer, price);
        }
        return answer;


    }

    class Point {
        int x;
        int y;
        int d;

        Point (int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;

        }
    }
}
