package study;

import java.util.Scanner;

public class BOJ2748 {
    public static void main(String[] args) {
        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
        //n이 주어졌을 때 n번째 피보나치 수는? 0 = 0 번째 피보나치 수, n <=90
        //dp는 재귀적으로 점화식을 통해 푸는 것
        Scanner sc = new Scanner(System.in);
        long[] dp = new long[91];//index = 0-90
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[sc.nextInt()]);
    }
}
