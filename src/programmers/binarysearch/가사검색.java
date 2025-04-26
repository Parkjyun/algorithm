package programmers.binarysearch;

import java.util.*;

public class 가사검색 {
    public int[] solution(String[] words, String[] queries) {
        // ub, lb 활용했음 trie도 다시보자
        // 효율성 떨어져서 단어 개수에 따라 처음부터 map으로 나눠야 했음(처음에만 해두면 모든 queery에 대해 lb, ub 구할 떄 n 감소)
        int[] answer = new int[queries.length];

        Map<Integer, List<String>> map = new HashMap<>();
        Map<Integer, List<String>> rmap = new HashMap<>();

        for (String word : words) {
            int len = word.length();
            List<String> w = map.getOrDefault(len, new ArrayList<>());
            w.add(word);
            map.put(len, w);

            List<String> r = rmap.getOrDefault(len, new ArrayList<>());
            r.add(new StringBuilder(word).reverse().toString());
            rmap.put(len, r);
        }
        for (List<String> list : map.values()) {
            Collections.sort(list);
        }
        for (List<String> list : rmap.values()) {
            Collections.sort(list);
        }
        for (int i = 0; i < queries.length; i++) {

            String first;
            String last;
            if (queries[i].charAt(0) == '?') {
                first = new StringBuilder(queries[i]).reverse().toString().replaceAll("\\?", "a");
                last = new StringBuilder(queries[i]).reverse().toString().replaceAll("\\?", "z");
                List<String> reverseWords = rmap.getOrDefault(queries[i].length(), new ArrayList<>());
                int fi = lb(reverseWords, first);
                int li = ub(reverseWords, last);
                int c = 0;
                answer[i] = li-fi;
            } else {
                first = queries[i].replaceAll("\\?", "a");
                last = queries[i].replaceAll("\\?", "z");
                List<String> words2 = map.getOrDefault(queries[i].length(), new ArrayList<>());
                int fi = lb(words2, first);
                int li = ub(words2, last);

                answer[i] = li-fi;
            }
        }
        return answer;
    }

    int lb(List<String> words, String key) {
        int l = 0;
        int h = words.size();
        int m = 0;

        while(l < h) {
            m = (l+h)/2;
            if(words.get(m).compareTo(key) >= 0) h = m;
            else l = m+1;
        }
        return l;
    }

    int ub(List<String> words, String key) {
        int l = 0;
        int h = words.size();
        int m = 0;

        while(l < h) {
            m = (l+h)/2;
            if(words.get(m).compareTo(key) <= 0) l = m+1;
            else h = m;
        }
        return l;
    }
}
