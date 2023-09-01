package dynamicprogramming;

import java.util.Scanner;
//포도주 문제
//계단 오르기와 비슷
//3개가 연속이면 안됨 == 최대 2개까지만 인접할 수 있다 -> 점화식을 다음과 같이 구성
//dp[n] = gs[n] + gS[n-1] + dp[n-3]    gs[n] + dp[n-2]    dp[n-1] 중 최대
//왜 dp[n-1]을 비교 대상에 넣나요? 해당 문제에서는 gs의 마지막 index를 꼭 선택하지 않아도 됨 오히려 마지막 인덱스를 선택하지 않는게 클수도 있다는 것임
//xoox    oxoo 마지막을 선택하지 않은 전자가 더 클수도 있다 고로 dp[n-1]도 비교해줘야함.

public class BOJ2156 {

    static int n;
    static int[] givenSet;
    static int[] dp;//현재 내위치에서의 최선
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        givenSet = new int[n + 1];
        dp = new int[n + 1];

        for(int i = 1; i < n + 1;i++) {
            givenSet[i] = sc.nextInt();
        }
        dp[1] = givenSet[1];
        if(n >= 2)
            dp[2] = givenSet[2] + givenSet[1];



        for(int i = 3; i < n + 1;i++) {

            dp[i] = Math.max(dp[i-1] ,Math.max(dp[i-2], givenSet[i-1] + dp[i-3]) + givenSet[i]);
        }
        System.out.println(dp[n]);


    }
}
