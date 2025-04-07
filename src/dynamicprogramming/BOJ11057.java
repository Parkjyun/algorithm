package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // n자리 숫자이면서 끝자리가 두번째 인덱스인 친구들
        int[][] dp = new int[n + 1][10]; // 0 - 9
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < 10; j++) {
                int sum = 0;
                for (int k = 0; k <= j; k++) {
                    sum += dp[i-1][k];
                }
                dp[i][j] = sum % 10007;
            }
        }
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
        }
        System.out.println(answer % 10007);
    }
}
