package dynamicprogramming;

import java.util.Scanner;

public class BOJ1699 {
    static int n;//n을 표현하는데 필요한 최소한의 제곱수의 수를 구하는 문제
    static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new Integer[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 1; i <= n; i++) {
            dp[i] = i;//기본값을 넣는 것임 얘를 들면 n은 1의 제곱만으로 구하면 총 n번 든다
        }
        for(int i = 1; i <= n; i++) {//모든 dp[i]의 값을 구할 것이다 ---> 각각의 dp[i]마다
            for(int j = 1; j*j <= i; j++) {//각각의 dp[i]마다 dp[i]에는  n-제곱수 + 제곱수로 표현가능 == dp[n-j*j] + 1 이때 j에 123...여러가지 가능 고로 이들 중에 가장 작은 것
                if(dp[i] > dp[i - j*j] + 1 || dp[i] == null)//dp[i]가 초기화 되어있지 않거나 더 작은 dp를 만났다면
                    dp[i] = dp[i - j*j] + 1;
            }
        }
        System.out.print(dp[n]);
    }
}
