package dynamicprogramming;

import java.util.Scanner;

public class BOJ2293 {
    static int n;
    static int k;
    static int[] dp;
    static int[] coins;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        dp = new int[k+1];
        coins = new int[n+1];

        for(int i = 1; i <= n; i++) {
            coins[i] = sc.nextInt();
        }

        //1로만 했을 때 set
        dp[0] = 1;
        for(int i  = 1; i < coins.length; i++) {
            for(int j = 1; j < dp.length; j++) {
                if(j- coins[i]>= 0)
                    dp[j] = dp[j] + dp[j- coins[i]];

            }
        }
        System.out.print(dp[k]);

    }
}
