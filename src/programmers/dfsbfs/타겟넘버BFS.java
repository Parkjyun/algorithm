package programmers.dfsbfs;

import java.util.*;

public class 타겟넘버BFS {
    public int solution(int[] numbers, int target) {
        //bfs라 함은 두개의 길 중 하나를 고르는 것이다.
        int answer = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);

        for (int i = 0; i < numbers.length; i++) {
            int size = q.size();// 1 2 4 8 16 32
            for(int j = 0; j < size; j++) {
                int poll = q.poll();
                q.offer(poll + numbers[i]);
                q.offer(poll - numbers[i]);
            }
        }

        while(!q.isEmpty()) {
            if(q.poll() == target) answer++;
        }

        return answer;
    }
}
