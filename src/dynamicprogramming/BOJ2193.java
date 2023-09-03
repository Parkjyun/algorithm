package dynamicprogramming;

import java.util.Scanner;

public class BOJ2193 {
    static int n;
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < dp.length;i++) {
            for(int j = i-2; j >= 0; j--)
                dp[i] += dp[j];
        }
        System.out.print(dp[n]);
    }

}
