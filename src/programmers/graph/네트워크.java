package programmers.graph;

import java.util.*;

public class 네트워크 {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        Queue<Integer> q = new LinkedList();

        for (int j = 0; j < n; j++) {
            if (visited[j]) continue;
            System.out.println(j);
            q.offer(j);
            visited[j] = true;
            answer++;

            while(!q.isEmpty()) {
                int p = q.poll();
                for(int i = 0; i < computers.length; i++) {
                    if (computers[p][i] == 1 && !visited[i]) {
                        q.offer(i);
                        visited[i] = true;
                    }
                }
            }
        }
        return answer;
    }
}
