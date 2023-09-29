package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7576 {
    static int n;
    static int m;
    static int[][] tomatos;
    //1은 토마토 0은 익지 않은 토마토 -1은 토마토가 아예 없음
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int max = Integer.MIN_VALUE;
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        tomatos = new int[m][n];
        for (int i = 0; i < tomatos.length; i++) {
            for (int j = 0; j < tomatos[i].length; j++) {
                tomatos[i][j] = sc.nextInt();
            }
        }

        System.out.print(bfs());
    }
        static int bfs() {// -1은 토마토가 없어 0은 익지 않은 토마토  1은 익은 토마토
            for (int i = 0; i < tomatos.length; i++) {
                for (int j = 0; j < tomatos[i].length; j++) {
                    if (tomatos[i][j] == 1) {//동시에 굳이 하지 않아도 그냥 값을 통헤 알려줘도 되긴 해
                        queue.offer(new Point(i, j));
                    }
                }
            }//먼저 후보들을 다 넣고 시작해야 한다
                while (!queue.isEmpty()) {
                    Point p = queue.remove();
                    for (int l = 0; l < 4; l++) {
                        int nx = p.x + dx[l];
                        int ny = p.y + dy[l];

                        if (0 > nx || nx >= m || 0 > ny || ny >= n) continue;
                        if (tomatos[nx][ny] == 0) {
                            tomatos[nx][ny] = tomatos[p.x][p.y] + 1;
                            queue.offer(new Point(nx, ny));

                        }

                    }
                }


                for (int i = 0; i < tomatos.length; i++) {
                    for (int j = 0; j < tomatos[i].length; j++) {
                        if (tomatos[i][j] == 0) return -1;//0 익지 않은 토마토 -> 고로 익지 않은 것이 하나라도 있다면 -1을 출력한다.

                        max = Math.max(tomatos[i][j], max);


                    }
                }
                return max - 1;//만약 처음부터 모두 익어있어서 모두 1이라면 0을 출력
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

