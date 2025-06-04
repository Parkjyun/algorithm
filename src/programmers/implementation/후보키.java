package programmers.implementation;

import java.util.*;

public class 후보키 {
    public int solution(String[][] relation) {
        int v = relation.length;
        List<Integer> keys = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            dfs(0, 0, keys, i+1, new ArrayList<>(), v, relation);
        }

        boolean[] visited = new boolean[keys.size()];
        int answer = 0;
        for (int i = 0; i < keys.size(); i++) {
            if (visited[i]) continue;
            int can = keys.get(i);
            visited[i] = true;
            answer++;
            for (int j = i+1; j < keys.size(); j++) {
                if (visited[j]) continue;
                int com = keys.get(j);
                if ((can & com) == can) { // 겹친다.
                    visited[j] = true;
                }
            }
        }
        return answer;
    }

    // index에는 0123조합이 들어간다. obj 는 1개 2개 3개 4개
    void dfs(int depth, int start, List<Integer> set, int obj, List<Integer> index, int snum, String[][] relation) { // set에는 0123이 들어간다.
        if (obj == depth) {//키 조합 생성
            Set<String> temp = new HashSet<>();
            for (int i = 0; i < snum; i++) { // 학생수만큼
                String infos[] = relation[i];
                String[] e =new String[obj];
                for (int j = 0; j < e.length; j++) {
                    e[j] = infos[index.get(j)]; // i번째에 키중 i번째에 해당하는 info를 넣는다.
                }
                temp.add(Arrays.toString(e));
            }
            if (temp.size() == snum) { // 키로 들어온 놈이 모두 다르다면
                int binary = 0;
                for (int a : index) {
                    System.out.print(a);
                    binary += (int)Math.pow(2, a);
                }
                set.add(binary);
            }
            return;
        }

        for (int i = start; i < relation[0].length; i++) {
            index.add(i);
            dfs(depth+1, i+1, set, obj, index, snum, relation);
            index.remove(index.size()-1);
        }
    }
}
