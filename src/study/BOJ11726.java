package study;

import java.util.Scanner;

public class BOJ11726 {
    public static void main(String[] args) {
        //사실 n을 1과2로 나누어라
        int[] dp = new int[1001];//0 - 1000;
        Scanner sc = new Scanner(System.in);
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            /*
            * a = 10007 * 14 + 10006
            * b = 10007 * 1 + 11;
            * (a + b) % 10007을 할 수가 없다 dp 배열에 a, b를 그대로 저장할 수가 없음, 오버플로우 일어나니까
            * 그런데 (a + b) % 10007 == (a%10007 + b%10007) % 10007
            * 전자 => 10007 * 16 + 10 -> 10
            * 후자 => (10006 + 11) % 10007 -> 10 same
            * 그러면 dp 에 %10007한 놈들 저장하고 출력할 때 한번 더 나눠주자
            * */
            dp[i] = (dp[i-1]% 10007 + dp[i-2]% 10007) ;
        }

        System.out.println(dp[sc.nextInt()]%10007);

    }
}
