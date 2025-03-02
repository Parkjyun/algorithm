package programmers.heap;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            q.offer(scoville[i]);
        }

        int answer = 0;
        while (q.peek() < K) {
            if(q.size() == 1) return -1;
            int smallest = q.poll();
            int smallest2 = q.poll();

            int mixed = smallest + smallest2*2;

            q.offer(mixed);
            answer++;
        }
        return answer;
    }
}



