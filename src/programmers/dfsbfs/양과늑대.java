package programmers.dfsbfs;

import java.util.*;

public class 양과늑대 {
    List<List<Integer>> map = new ArrayList<>();
    Set<Integer> visited;
    Set<Integer> toVisit;
    int answer = Integer.MIN_VALUE;
    public int solution(int[] info, int[][] edges) {

        for (int i = 0; i < info.length; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
        }

        visited = new HashSet<>();
        toVisit = new HashSet<>();
        dfs(0, 1, 0, 0, info);
        return answer;
    }
    void dfs(int depth, int s, int w, int start, int[] info) {

        visited.add(start);
        toVisit =new HashSet<>();
        for (int v : visited) {
            for (int toV :map.get(v)) {
                if (!visited.contains(toV))
                    toVisit.add(toV);
            }
        }

        if (depth == map.size() || toVisit.isEmpty() ||  w >= s) {
            answer = Math.max(answer, s);
            return;
        }
        for (int c : toVisit) {
            if (info[c] == 0) { // 다음이 양
                dfs(depth+1, s+1, w, c, info);

            } else {
                dfs(depth+1, s, w+1, c, info);
            }
            visited.remove(c);
        }

    }
}
