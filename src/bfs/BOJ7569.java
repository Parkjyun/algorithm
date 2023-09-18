package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//상하좌우앞뒤로 익은 거 옆은 익게 된다
//첫입력 3개는 높이, 가로, 세로
//이후 부터는 가로의 개수만큼 세로번 토마토를 준다
//1= 익은 0 = 익지 않은 -1 = 들어있지 않음

public class BOJ7569 {
    static int g;
    static int s;
    static int h;
    static int[][][] tomato;//height, 세로, 가로
    static int answer = 0;
    static int[] hd = {0,0,0,0,-1,1};
    static int[] sd = {1,0,-1,0,0,0};
    static int[] gd = {0,1,0,-1,0,0};
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        g = sc.nextInt();
        s = sc.nextInt();
        h = sc.nextInt();
        tomato = new int[h][s][g];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < s; j++) {
                for (int l = 0; l < g; l++)
                    tomato[i][j][l] = sc.nextInt();
            }
        }
        System.out.println(bfs());
    }
    static int bfs() {//되면 초 출력 //다 익지 못하면 -1 출력
    //1. 배열을 돌며 익은 애들을 넣음
        // 매초 마다 익은 애들의 주변을 익게 만들고, 새로 익은 애들을 큐에 넣는다
        //bfs다 끝났을 때 0이 남아있다면 -1 출력
        for(int i = 0; i < tomato.length; i++) {//height
            for(int j = 0; j < tomato[i].length; j++) {//세로
                for (int l = 0; l < tomato[i][j].length; l++) {//가로
                    if (tomato[i][j][l] == 1) {
                        queue.offer(new Point(i, j, l));
                    }
                }
            }
        }
        while(!queue.isEmpty()) {
            Point p = queue.poll();
//1은 익은 토마토, 0은 익지 않은 토마토, -1은 없음
            //높tork
            for(int i = 0; i < 6; i++) {
                int nh = p.h + hd[i];
                int ns = p.s + sd[i];
                int ng = p.g + gd[i];
                if(nh < 0 || ns <0 || ng < 0 || nh >= h || ns >= s || ng >= g ) continue;;//새로운 포인트의 제한 조건드릉ㄹ 적므
                if(tomato[nh][ns][ng] == -1 || tomato[nh][ns][ng] != 0) continue;
                tomato[nh][ns][ng] = tomato[p.h][p.s][p.g] + 1;
                queue.offer(new Point(nh, ns, ng));
            }
        }
        answer = Integer.MIN_VALUE;
        for(int i = 0; i < tomato.length; i++) {//height
            for (int j = 0; j < tomato[i].length; j++) {//세로
                for (int l = 0; l < tomato[i][j].length; l++) {
                    if(tomato[i][j][l] == 0) return -1; //만약 하나라도 익지 않은 것이 있다면 -1
                    answer = Math.max(answer, tomato[i][j][l]);
                }

            }
        }
        if (answer == 1) return 0;
        else return answer - 1;
    }
    static class Point {
        int g;
        int s;
        int h;
        Point(int h, int s, int g) {
            this.g = g;
            this.s = s;
            this.h = h;

        }
    }
}
