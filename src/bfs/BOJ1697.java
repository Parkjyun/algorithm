package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697 {//481617
    //bfs
    //배열의 인덱스는 위치, 값은 해당 위치에 오기위한 초
    static int n;
    static int k;
    static int[] pos = new int[100001];//모두 0으로 초기화,
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        if(n == k) System.out.println(0);
        else {
            bfs();
        }

    }
    static void bfs() {
        queue.offer(n);
        pos[n] = 1;

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int i = 0; i < 3; i++) {
                int next;
                if(i == 0) {
                    next = temp + 1;
                } else if (i == 1){
                    next = temp -1;
                } else {
                    next = temp * 2;
                }
                if (next == k) {
                    System.out.println(pos[temp]);//1초부터 넣았음 고로 next가 k라는 것은 1 + n회만에 찾았다
                    return;
                }
                if(next >= 0 && next <= 100000 && pos[next] == 0) {//pos == 0 만약 방문하지 않은 곳이라면
                    queue.offer(next);
                    pos[next] = pos[temp] + 1;
                }
            }

        }
    }
}
