package dynamicprogramming;

import java.util.Scanner;

//dp는 해당 인덱스에서 끝나는 수의 부붑수열의 길이의 값
public class BOJ11053 {
    static int n;
    static int[] dp;
    static int[] gs;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+1];
        gs = new int[n+1];

        for(int i = 1; i < gs.length; i++) {
            gs[i] = sc.nextInt();
        }
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < gs.length; i++) {
            dp[i] = 1;
            for(int j = 1; j < i ;j++) {
                if(gs[i] > gs[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int max = 0;
        for(int i = 1; i < dp.length; i++) {
            if(dp[i] > max) max = dp[i];
        }
        System.out.println(max);

    }
}
