package backtracking;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ1941 {
    static char[][] givenSet;
    static int answer = 0;
    static int[] seats;
    static boolean[] visited;
    static boolean[] bfsvisited;
    static int[] xDir = {0,1,0,-1};
    static int[] yDir = {1,0,-1,0};


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //조합을 넣기 위한 자리
        seats = new int[7];
        givenSet = new char[5][5];
        visited = new boolean[25];
        for(int i = 0; i < 5; i++) {
            givenSet[i] = sc.next().toCharArray();
        }

        comb(0,0, 0);
        System.out.println(answer);

    }
    static void comb(int depth, int start, int count) {
        int x;
        int y;

        if(depth == 7) {
            if(count >= 4) {
                if(bfs()) {
                    answer++;
                    return;
                }
            }
            return;
        }

        //조합
        for(int i = start; i < 25; i++) {
                x = i / 5;
                y = i % 5;
                if(visited[i] == false) {
                    visited[i] = true;
                    seats[depth] = i;
                    if(givenSet[x][y] == 'S') comb(depth+1, i + 1, count + 1);//s파의 수를 센다
                    else comb(depth+1, i + 1, count);
                    visited[i] = false;
                }


        }
    }

    static boolean bfs() {
        int cnt = 1;//재귀 사용하지 않음
        bfsvisited = new boolean[25];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(seats[0]);

        while (!stack.isEmpty()) {//만약 stack이 비어 있지 않다면 아래를 계속한다
            int now = stack.pop();
            bfsvisited[now] = true;
            for (int i = 0; i < 4; i++) {

                int x = (now / 5) + xDir[i];
                int y = (now % 5) + yDir[i];
                /////주어진 점에서 동서남북 각 회차마다 유효한지 검증//////
                //기준점에서 이동 후 범위를 벗어나면 continue
                if (x < 0 || x >= 5 || y < 0 || y >= 5) continue;
                //기준점에서 이동후 이미 bfs에서 방문한 지점이면 continue
                if (bfsvisited[x * 5 + y] == true) continue;
                //기준점에서 이동후 comb가 아니면(공주가 아니라면) pass
                if (visited[x * 5 + y] == false) continue;
                //공주라면
                cnt++;
                stack.push(x * 5 + y);
                bfsvisited[x * 5 + y] = true;
            }
        }
        if(cnt == 7) return true;
        else return false;
        }
}
