package programmers.binarysearch;

import java.util.Arrays;

public class 징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int l = 1;
        int h = distance;
        int m = l + (h-l)/2;
        int answer = 0;
        Arrays.sort(rocks);
        while (l <= h) {
            m = l + (h-l)/2;
            System.out.println("m : " + m);
            int dC = calculate(rocks, m, distance);
            System.out.println("dc : " + dC);

            if (dC > n) {
                System.out.println("1");
                h = m - 1;
            } else {
                System.out.println("2");
                answer = m;
                l = m + 1;
            }
        }
        return answer;
    }

    //rocks에서 돌간최소 간격이 m이기 위해 제거해야 하는 최소한의 바위의 수는??
    int calculate(int[] rocks, int m, int distance) {
        int before = 0;
        int answer = 0;
        for (int i = 0; i < rocks.length; i++) {
            if(rocks[i] - before < m) {
                answer++;
            } else {
                before = rocks[i];
            }
        }
        if (distance - before < m) answer++;
        return answer;
    }
}
