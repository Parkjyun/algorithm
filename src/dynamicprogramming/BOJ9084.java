package dynamicprogramming;

import java.util.Scanner;

public class BOJ9084 {//경우의수를 찾는
    static int t;
    static int[] cN;//각 테스트 동전의수
    static int[][] coins;//각 테스트의 동전수
    static int[] obj;//각 테스트별 목표 금액
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        cN = new int[t+1];//인덱스별로 각 테스트 동전의 수를 입력
        coins = new int[t+1][];//각테스트별로 동전의 가치를 입력
        obj = new int[t+1];
        for(int i = 1; i <= t; i++) {
            cN[i] = sc.nextInt();
            coins[i] = new int[cN[i] + 1];
            for(int j = 1; j <= cN[i]; j++) {
                coins[i][j] = sc.nextInt();
            }
            obj[i] = sc.nextInt();

        }
        for(int i = 1; i <= t; i++) {
            dp(i);
        }
        System.out.print(sb);
    }
    //테스트의 인덱스를 받아 bottomup dp를 실행하는 함수
    static void dp(int l) {// i는 테스트의 Index를 넘겨준다. dp[j] = dp[j - coins[i]] + 1
        dp = new int[obj[l] + 1];//obj[l]은 각 테스트의 목표 금액
        dp[0] = 1;//처음에 1을 더하기 위한 용도
        for(int i = 1; i <= cN[l]; i++) {//cN -> 0~t cn[l] = 2
            for(int j = coins[l][i]; j <= obj[l]; j++) {//1
                dp[j] = dp[j-coins[l][i]] + dp[j];
            }
        }
        sb.append(dp[obj[l]] + "\n");
    }
}
