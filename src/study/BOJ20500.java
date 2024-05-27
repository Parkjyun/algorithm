package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[1516][3];

        dp[1][0] = 0;
        dp[1][1] = 0;
        dp[1][2] = 1;

        for (int i = 2; i <= 1515; i++) {
            dp[i][0] = (dp[i-1][1] % 1000000007 + dp[i-1][2] % 1000000007) % 1000000007;
            dp[i][1] = (dp[i-1][0] % 1000000007 + dp[i-1][2] % 1000000007) % 1000000007;
            dp[i][2] = (dp[i-1][1] % 1000000007 + dp[i-1][0] % 1000000007) % 1000000007;
        }

        System.out.println(dp[n][0]);
    }
}
