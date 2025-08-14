package programmers.implementation;

import java.util.PriorityQueue;

public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {//백만 round, k는 50만
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int answer = 0;
        for (int i = 0; i < enemy.length; i++) {
            n = n - enemy[i];
            pq.offer(enemy[i]);
            if (n < 0) {
                if (k > 0) {
                    n += pq.poll();
                    k--;
                } else {

                    break;
                }
            }
            answer = i+1;
        }
        return answer;
    }
}
