package programmers.heap;

import java.util.*;

public class 야근지수 {

    public long solution(int n, int[] works) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) pq.add(w);

        for (int i = 0; i < n; i++) {
            int max = pq.poll();
            if (max == 0) break;
            pq.offer(max-1);
        }

        long answer = 0;
        for (int p : pq) {
            answer += p*p;
        }
        return answer;
    }
}
