package programmers.greedy;

import java.util.*;

public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        A = Arrays.stream(A)
                .boxed()
                .sorted((a, b) -> b - a)
                .mapToInt(Integer::intValue)
                .toArray();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for (int i = 0; i < B.length; i++) {
            pq.offer(B[i]);
        }

        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            if(!pq.isEmpty() && A[i] < pq.peek()) {
                answer++;
                pq.poll();
            }
        }
        return answer;
    }
}
