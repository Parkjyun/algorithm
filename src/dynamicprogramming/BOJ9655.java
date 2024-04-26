package dynamicprogramming;

import java.util.Scanner;

public class BOJ9655 {
    public static void main(String[] args) {
        /*
        dp[i] = 1;
        돌이 i개 남았을 때 본인 차례에 1나오면 이기는 것임
        * */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 0;

        for (int i = 5; i <= n; i++) {
            if (dp[i-1] == 1 && dp[i-3] == 1 )
                dp[i] = 0;
            else dp[i] = 1;
        }

        if (dp[n] == 1) System.out.println("SK");
        else System.out.println("CY");


    }
}
