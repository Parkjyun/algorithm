package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//bfs를 할 때 배열의 값을 갱신하여 걸린 시간을 알아낼 수 있다.

public class BOJ7569 {
    static int g;
    static int s;
    static int h;
    static int[][][] tomato;//height, 세로, 가로 -> 여기에 요소로 걸린 일수를 저장할 것임.
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
        for(int i = 0; i < h; i++) {//3차원 배열에 다 넣는다.
            for(int j = 0; j < s; j++) {
                for (int l = 0; l < g; l++)
                    tomato[i][j][l] = sc.nextInt();
            }
        }
        System.out.println(bfs());
    }
    static int bfs() {
        for(int i = 0; i < tomato.length; i++) {
            for(int j = 0; j < tomato[i].length; j++) {
                for (int l = 0; l < tomato[i][j].length; l++) {
                    if (tomato[i][j][l] == 1) {//모든 요소를 돌면서 만약 익은 토마토가 있다면 큐에 넣는다.
                        queue.offer(new Point(i, j, l));
                    }
                }
            }
        }
        while(!queue.isEmpty()) {//큐가 빌때까지 다음을 한다.
            Point p = queue.poll();//큐에서 하나 빼오고
//1은 익은 토마토, 0은 익지 않은 토마토, -1은 없음
            //높tork
            for(int i = 0; i < 6; i++) {//각각의 방향으로 가능한 놈들을 찾는다.
                int nh = p.h + hd[i];
                int ns = p.s + sd[i];
                int ng = p.g + gd[i];
                // 1. 만약 범위를 벗어나거나 2. 자리에 토마토가 없거나 3. 토마토가 이미 익었다면 continue;
                if(nh < 0 || ns <0 || ng < 0 || nh >= h || ns >= s || ng >= g ) continue;;//새로운 포인트의 제한 조건드릉ㄹ 적므
                if(tomato[nh][ns][ng] == -1 || tomato[nh][ns][ng] != 0) continue;
                tomato[nh][ns][ng] = tomato[p.h][p.s][p.g] + 1;//범위를 벗어나지 않고 자리에 토마토가 있고 토마토가 안 익은 것은 익히면서 day update
                queue.offer(new Point(nh, ns, ng));//얘네들을 큐에 넣고 큐가 빌때까지 == 더 이상 익힐 과일 후보가 없을 때까지 과정 반복
            }
        }
        answer = Integer.MIN_VALUE;
        for(int i = 0; i < tomato.length; i++) {//height
            for (int j = 0; j < tomato[i].length; j++) {//세로
                for (int l = 0; l < tomato[i][j].length; l++) {
                    if(tomato[i][j][l] == 0) return -1; //만약 하나라도 익지 않은 것이 있다면 -1출력
                    answer = Math.max(answer, tomato[i][j][l]);//요소의 최댓값을 찾음
                }

            }
        }
        if (answer == 1) return 0;//만약 요소의 최댓값이 1이라면 모든 요소가 처음부터 익었다는 뜻 고로 0을 출력
        else return answer - 1;// 아닌경우 0을 출력
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
