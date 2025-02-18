package programmers;

import java.util.*;

public class 의상 {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            map.computeIfAbsent(clothes[i][1], c -> new ArrayList()).add(clothes[i][0]);
        }
        //각각의 (개수 + 1) * (개수 + 1) - 1
        int answer = 1;
        for(String key : map.keySet()) {
            answer *= map.get(key).size() + 1;

        }
        return answer -1;
    }
}
