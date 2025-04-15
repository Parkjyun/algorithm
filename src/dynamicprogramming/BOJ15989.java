package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15989 {
    public static void main(String[] args) throws IOException {
        //dp는 상태값
        //dp[n][k] n을 만들기 위해 사용할 수 있는 최대 값은 k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[10001][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < 10001; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            System.out.println(dp[a][1] + dp[a][3] + dp[a][2]);
        }
    }
}
