package programmers.binarysearch;

import java.util.*;

public class 순위검색 {
    Map<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        StringTokenizer st;
        for (String s : info) {
            //ex s -> java backend junior pizza 150;
            String[] arr = s.split(" ");

            // sb생성 완료

            int score = Integer.parseInt(arr[4]);
            dfs(0, arr, score, "");
            //map 완료
        }
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        for (int i = 0; i < query.length; i++) {
            StringBuilder sb = new StringBuilder();
            String arr[] = query[i].split(" and ");
            String[] arr2 = arr[3].split(" ");
            sb.append(arr[0]);
            sb.append(arr[1]);
            sb.append(arr[2]);
            sb.append(arr2[0]);

            List<Integer> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            answer[i] = list.size() - lb(Integer.parseInt(arr2[1]), list);

        }
        return answer;
    }

    void dfs(int depth, String[] arr, int score, String sb) {
        if (depth == 4) {
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            List<Integer> list = map.get(sb.toString());
            list.add(score);
            return;
        }
        dfs(depth+1, arr, score, sb + "-");
        dfs(depth+1, arr, score, sb + arr[depth]);
    }

    int lb (int key, List<Integer> arr) {
        int l = 0;
        int h = arr.size();

        int m = 0;

        while (l < h) {
            m = l + (h-l)/2;
            if (arr.get(m) >= key) {
                h = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
}
