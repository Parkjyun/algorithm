package programmers.dfsbfs;

import java.util.*;

public class 비밀코드해독 {
    Set<Integer> set = new HashSet<>();
    int answer = 0;


    public int solution(int n, int[][] q, int[] ans) {
        //1 - n까지 오름 차순 서로 다른 정수 5개
        // m 번의 시도
        // q는 입력한 정수 -> 각각 원소는 5개
        //m개의 14689... => ans[i] = 14689중 몇개?

        //n개로 이루어진 조합을 찾는다.
        // q돌며 같은지 확인한다.
        comb(0,0, q, ans, n);
        return answer;
    }

    void comb (int depth, int start, int[][] q, int[] ans, int n) {
        if (depth == 5) {
            boolean f = true;// 기본은 참
            for (int i = 0; i < q.length; i++) { // 하나의 시도arr에 대해 확인
                int s = 0;
                for (int j = 0; j < q[i].length; j++) { // 각각의 숫자에 대해
                    if (set.contains(q[i][j])) {
                        s++;
                    }
                }
                if (s != ans[i]) {//다르다면
                    f = false;
                }

            }
            if (f) {
                answer++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            set.add(i+1);
            comb(depth+1, i+1,q,ans,n);
            set.remove(i+1);
        }
    }
}
