package programmers.implementation;

import java.util.*;

public class 줄서는방법 {


    public int[] solution(int n, long k) {


        k--;
        int answer[] = new int[n];
        int i = 0;

        List<Integer> list = new ArrayList<>();
        List<Long> fac = new ArrayList<>();
        long fa = 1;
        fac.add(1L);
        for (int a = 1; a < n; a++) {
            fa *= a;
            fac.add(fa);
        }
        for (int l = 1; l <= n; l++) {
            list.add(l);
        }
        // i 012
        // v 126
        while (n-- > 0) { //n번실행 예제에서는 최초 n-- 하면 2
            long f = fac.get(n);
            long index = k / f;
            answer[i++] = list.remove((int)index);
            k = k % f;

        }
        return answer;

    }

    long fac(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return (long)n * fac(n-1);
        }

    }
}
