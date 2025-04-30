package programmers.implementation;

import java.util.*;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        //유저별로 처리 결과 메일을 받은 횟수를 return
        //1인이 1인 여러번 신고시 1회만 처리
        // k회 이상 신고된 유저는 이용 정지, 해당 유저를 신고한 모두에게 메일 발송
        // map reportby = 신고당한사람, 신고자Set
        // map reportCount
        // map String, index
        // 1. report를 돌면서 reportby에 없다면 reportCount를 올리고 reportBy에 추가
        //2. reportCount를 돌면서 k이상이라면 reportby에서 신고자를 찾아서 ++해준다.
        int[] answer = new int[id_list.length];
        Map<String, Integer> index = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        Map<String, Set<String>> reportBy = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            index.put(id_list[i], i);
        }

        StringTokenizer st;
        for (String s : report) {
            st = new StringTokenizer(s);
            String by = st.nextToken();
            String to = st.nextToken();

            if (reportBy.getOrDefault(to, new HashSet<>()).contains(by)) { // 이전에 by가 to를 신고했다면

            } else { // by 가 to 첫신고
                int nc = count.getOrDefault(to, 0) + 1;
                count.put(to, nc);
                Set<String> set = reportBy.getOrDefault(to, new HashSet<>());
                set.add(by);
                reportBy.put(to, set);
            }


        }
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            if (e.getValue() >= k) {
                Set<String> re = reportBy.get(e.getKey());
                for (String i : re) {
                    int n = index.get(i);
                    answer[n]++;
                }
            }
        }

        return answer;
    }
}
