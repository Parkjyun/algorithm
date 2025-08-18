package programmers.dfsbfs;

import java.util.*;

public class 홀짝트리 {
    Map<Integer, List<Integer>> adj = new HashMap();
    Set<Integer> visited = new HashSet<>();
    int y = 0;//홀짝
    int r = 0;//역홀짝
    public int[] solution(int[] nodes, int[][] edges) {
        //정점, 자식
        int answer[] = new int[] {0, 0};
        for (int i = 0; i < nodes.length; i++) {
            adj.put(nodes[i], new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            //+1
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        for (int i = 0; i < nodes.length; i++) {
            y = 0;
            r = 0;
            dfs(nodes[i]);
            if (y == 1) {
                answer[0]++;
            }
            if (r == 1) {
                answer[1]++;
            }
        }
        return answer;
    }

    void dfs(int n) {
        if (visited.contains(n)) {
            return;
        }
        visited.add(n);
        if (n%2 == 0) {
            if (adj.get(n).size() % 2 == 0) {
                y++;
            } else {
                r++;
            }
        } else {
            if (adj.get(n).size() % 2 == 0) {
                r++;
            } else {
                y++;
            }
        }

        for (int next : adj.get(n)) {
            dfs(next);
        }


    }
}
