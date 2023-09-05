package dynamicprogramming;

import java.util.Scanner;

//길이 n짜리를 1, 2a 2b로 표현한다
//dp[1] = 1 (1);
//dp[2] = 3 (11 a b)
//dp[3] = 5 (111 a1 1a 2b b1)
//dp[4] = 11 (1111, aa, bb, ab, ba, a11, 1a1, 11a, b11, 1b1, 11b)
//
//dp[n] = dp[n-1] + 2 * dp[n-2];


public class BOJ11727 {

    static int n;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }
        System.out.print(dp[n]);
    }

}
