package dynamicprogramming;

import java.util.Scanner;

public class BOJ11055 {
    static int n;
    static int[] a;
    static int[] dp;//합이 증가하는 수열
    static int newIndex;
    static int sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n+1];
        dp = new int[n+1];
        for(int i = 1; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        dp[1] = a[1];
        sum = a[1];
        newIndex = 1;
        for(int i = 2; i < dp.length; i++) {
            dp[i] = a[i];
            for(int j = 1; j < i;j++) {
                if (a[i] > a[j])//만약 현재 index의 값이 전꺼보다 크다면 ==> 증가하는 수열이라면
                    dp[i] = Math.max(dp[j] + a[i],dp[i]);
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++)
            if(dp[i] > max) max = dp[i];
        System.out.println(max);


    }
}
