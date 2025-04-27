package programmers.binarysearch;

import java.util.*;

public class 주사위고르기 {
    List<Integer> selected = new ArrayList<>();
    int n;
    Map<Integer, List<Integer>> map = new HashMap<>();
    // k : 0123... nc2-1
    List<List<Integer>> combs = new ArrayList<>(); // k의 에 해당하는 것이 해당번째 comb
    int ci = 0;

    public int[] solution(int[][] dice) {
        int[] answer = new int[2];
        n = dice.length;
        dfs(0, 0);
        //조합 다 만들었음

        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            // 조합 index, 빈 리스트 -> 가능한 모든 케이스 넣어야 돼.
            List<Integer> comb = combs.get(e.getKey());
            findSum(0, dice, comb, 0, e.getValue());
            Collections.sort(e.getValue());
        }


        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            int ak = e.getKey();//조합 index
            List<Integer> la = e.getValue();

            int bk = ci - 1 - ak;//상대조합 Index
            List<Integer> lb = map.get(bk);
            int win = 0;
            for (int b : lb) {
                win += la.size() - lb(b+1, la);
            }

            if (win > max) {
                max = Math.max(win, max);

                answer = combs.get(ak).stream().mapToInt(i->i+1).toArray();
            }
        }
        return answer;
    }

    void findSum(int depth, int[][] dice, List<Integer> comb, int sum, List<Integer> sums) {
        if (depth == comb.size()) {
            sums.add(sum);
            return;
        }
        for (int i = 0; i < 6; i++) {
            sum += dice[comb.get(depth)][i];
            findSum(depth+1, dice ,comb, sum, sums);
            sum -= dice[comb.get(depth)][i];
        }
    }



    void dfs(int depth, int start) {
        if (depth == n/2) {
            combs.add(new ArrayList<>(selected));
            //selected에 조합 있음
            map.put(ci++, new ArrayList<>());
        }

        for (int i = start; i < n; i++) {
            selected.add(i);
            dfs(depth+1, i+1);
            selected.remove(selected.size() - 1);

        }
    }

    int lb(int key, List<Integer> list) {
        int l = 0;
        int h = list.size();
        int m = 0;
        while(l < h) {
            m = (l+h)/2;

            if (list.get(m) >= key) {
                h = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
}
