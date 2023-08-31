package dynamicprogramming;

import java.util.Scanner;
//계속 %1000000000하는 이유..
//문제에서 출력을 1000000000으로 나눈 나머지를 출력하라 했다
//n이 커질수록 결과가 매우 커지니 그랬겠지... 그래서 내가 관심있는 것은 나머지만 관심있다.
//(2+3+4+7) % 10 과 (2%10 +3%10 +4%10 +7%10) % 10은 동일하다
/////////////////////////////////////////////
//n이 100이니 경우의 수가 long값을 벗어날 것이다.
//고로 나머지 값만 return해주어야 한다,
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
