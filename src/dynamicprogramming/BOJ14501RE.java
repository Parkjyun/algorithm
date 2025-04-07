package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14501RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if (i + t - 1 <= n) { //n일까지 일할 수 있다면
                dp[i+t-1] = Math.max(dp[i-1] + p, dp[i+t-1]);
            }
            dp[i] = Math.max(dp[i-1], dp[i]);
            }
        System.out.println(dp[n]);
        }
}
