package dynamicprogramming;

import java.util.Scanner;

public class BOJ10844 {
    static int n;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp = new int[n+1][10];
        dp[1][0] = 0;
        for(int i = 1; i<=9; i++)
            dp[1][i] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <=9; j++) {
                if(j ==0) {
                    dp[i][j] = dp[i-1][1]%1000000000;
                } else if (j == 9) {
                    dp[i][j] = dp[i-1][8]%1000000000;
                } else {
                    dp[i][j] = dp[i - 1][j - 1]%1000000000 + dp[i - 1][j + 1]%1000000000;
                }
            }
        }
        long sum = 0;
        for(int i = 0; i <= 9; i++) {
            sum += dp[n][i];

        }
        System.out.print(sum%1000000000);

    }
}
