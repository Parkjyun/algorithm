package programmers.twopointer;

import java.util.*;

public class 보석쇼핑 {
    int maxS = Integer.MAX_VALUE;
    int as = 0;
    int ae = 0;
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }
        int v = set.size();
        int start = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int end = 0; end < gems.length; end++) {
            //end를 올릴 때마다 map에 넣어준다.
            int value = map.getOrDefault(gems[end], 0);
            map.put(gems[end], value + 1);
            if (isAll(map, v)) { // 이번 end에서 모든 종류라면
                // 기록하고
                if (end - start < maxS) {
                    as = start;
                    ae = end;
                    maxS = end - start;
                }
                while (start < end) {//start를 올려보자
                    delete(map, gems[start]);//0번지우고
                    start++;//start를 1로
                    if (isAll(map, v)) { //start를 하나 올렸는데 모든 종류 충족
                        //기록하자
                        if (end - start < maxS) {
                            as = start;
                            ae = end;
                            maxS = end - start;
                        }

                    } else { //start를 하나 올렸는데 모든 종류 충족 x -> end 올리자
                        break;
                    }
                }
            }
        }
        return new int[] {as+1, ae+1};
    }

    void delete(Map<String, Integer> map, String key) {
        int r = map.get(key) - 1;
        map.put(key, r);
        if (r == 0) map.remove(key);
    }

    boolean isAll(Map<String, Integer> map, int v) {
        return map.size() == v;
    }
}
