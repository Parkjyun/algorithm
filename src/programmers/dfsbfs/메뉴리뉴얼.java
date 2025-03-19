package programmers.dfsbfs;

import java.util.*;

public class 메뉴리뉴얼 {
    Map<String, Integer> map;
    boolean[] visited;
    int max;
    public String[] solution(String[] orders, int[] course) {

        //각각의 손님의 메뉴까지 정렬해버리기
        for (int i = 0; i < orders.length; i++) {
            char[] cA = orders[i].toCharArray();
            Arrays.sort(cA);
            orders[i] = new String(cA);
        }

        map = new HashMap<>();
        List<String> a = new LinkedList<>();
        for (int i = 0; i < course.length; i++) {
            int num = course[i];//이번 코스의 개수에 대해
            max = Integer.MIN_VALUE;//이번 조합수에서 max는 어떤걸까
            for (int j = 0; j < orders.length; j++) {//모든 order를 순회하며 조합 map으로

                String order =  orders[j];
                visited = new boolean[order.length()];
                dfs(0,"", num, order, 0);
            }

            //max는 해당 코스에서 최대 빈출set
            for (String key : map.keySet()) {
                if (num == key.length()) {
                    if (max>=2 && map.get(key) == max) {
                        a.add(key);
                    }
                }
            }

        }
        String[] answer = a.stream().toArray(String[]::new);
        Arrays.sort(answer);
        return answer;

    }
    //obj는 몇개 뽑겟다~
    void dfs(int depth, String menu, int obj, String order, int start) {
        if (depth == obj) {
            int count = map.getOrDefault(menu, 0);
            map.put(menu, count+1);
            max = Math.max(max, count+1);
            return;
        }
        StringBuilder sb = new StringBuilder(menu);

        for (int i = start; i < order.length(); i++) {
            if(!visited[i]) { //방문하지 않았다면
                visited[i] = true;
                dfs(depth + 1, menu + order.charAt(i), obj, order, i+1);
                visited[i] = false;//visited풀어줌으로써
            }
        }
    }
}
