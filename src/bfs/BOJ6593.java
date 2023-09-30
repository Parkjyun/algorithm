package bfs;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ6593 {
    static int l;
    static int r;
    static int c;
    static int[] ld = {0, 0, 0, 0, 1, -1};
    static int[] rd = {0, 1, 0, -1, 0, 0};
    static int[] cd = {1, 0, -1, 0, 0, 0};
    static Queue<Point> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static char[][][] building;
    static int[][][] time;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true){
        l = sc.nextInt();
        if(l == 0) break;
        r = sc.nextInt();
        c = sc.nextInt();

        building = new char[l][r][c];//층, 행의 수, 열의 수
        time = new int[l][r][c];
        for (int i = 0; i < building.length; i++) {
            for (int j = 0; j < building[i].length; j++) {
                String str = sc.next();
                for (int l = 0; l < building[i][j].length; l++) {
                    building[i][j][l] = str.charAt(l);
                    if (building[i][j][l] == 'S') queue.offer(new Point(i, j, l));
                }
            }
            String temp = sc.nextLine();
        }

        bfs();

    }
        System.out.print(sb);
    }



    static void bfs() {
        while (!queue.isEmpty()) {//. 은 방문 가능 #은 방문 불가
            Point p = queue.poll();//하나 빼와서

            for(int i = 0; i < 6; i++) {//6방향을 모두 체크
                int nl = p.l + ld[i];
                int nr = p.r + rd[i];
                int nc = p.c + cd[i];
                if(nl >= 0 && nr >= 0 && nc >= 0 && nl < l && nr < r && nc < c) {
                    if ((building[nl][nr][nc] == '.' || building[nl][nr][nc] == 'E') && time[nl][nr][nc] == 0) {//결국 .들만 가게 되는데 만약 해당 포인트의 값이 0일때만 갈 수 있다.
                        queue.offer(new Point(nl, nr, nc));
                        time[nl][nr][nc] = time[p.l][p.r][p.c] + 1;

                    }
                }
            }
        }
        for(int i = 0; i < building.length; i++) {
            for(int j = 0; j < building[i].length; j++) {
                for(int l = 0; l < building[i][j].length; l++) {
                    if(building[i][j][l] == 'E') {
                        if(time[i][j][l] == 0) {
                            sb.append("Trapped!" + "\n");
                        } else {
                            sb.append("Escaped in " + time[i][j][l] + " minute(s)." + "\n");
                        }
                    }
                }
            }
        }

    }


    static class Point {
        int l;
        int r;
        int c;

        Point(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;

        }
    }
}
