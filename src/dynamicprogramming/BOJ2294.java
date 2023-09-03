package dynamicprogramming;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class BOJ2294 {
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
        for(int i = 1; i < coins.length; i++)
            coins[i] = sc.nextInt();

        Arrays.fill(dp, 10001);//dp에서 최솟값 비교를 실행해야함 -> 초기값을 10000으로 와이ㅣ? k의 최댓값은 10000, 동전의 최소 값은 1 고로 가능한 최대의 dp는 100000, 마지막에 -1을 위해 10001사용.
        dp[0] = 0;
        for(int i = 1; i < coins.length; i++) {
            for(int j = coins[i]; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
//예를 들어 1 5 2 -> 5를 동전 2만을 사용해서 표현한다고 해보자
//        dp[1]= 10001, dp[2] = 1 dp[3]= 10001, dp[4] = 2, dp[5] = 100001
        //위처럼 딱 나누어 떨어지지 않는다면 dp값이 100001로 유지
        //애초에 coins[i]부터 시작하므로 나머지들이 남는 수는 노 초기화 + 1, dp를 min 비교하니 이렇게 되는 거임

            System.out.print(dp[k] == 10001? -1:dp[k]);

    }
}
