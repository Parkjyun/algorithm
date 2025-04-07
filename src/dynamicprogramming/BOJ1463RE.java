package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1463RE {
    public static void main(String[] args) throws IOException {
        /*
        주어진 숫자부터 3개의 연산을 하며 내려온다.

        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 2; i < n+1; i++) {//n부터 1까지
            if (i % 6 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, Math.min(dp[i / 2] + 1, dp[i - 1] + 1));
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i-1] + 1);
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i-1] + 1);
            } else {
                dp[i] = dp[i-1] + 1;
            }

        }
        System.out.println(dp[n]);

    }
}
