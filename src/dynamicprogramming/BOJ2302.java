package dynamicprogramming;

import java.util.Scanner;


public class BOJ2302 {
    static int n;
    static int[] dp;
    static boolean[] vip;
    static int answer;

    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+1];//dp는 연속된 자리의 조합수 dp3은 3개의 자리가 이동가능할때
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        int vC = sc.nextInt();
        vip = new boolean[n+2];
        for(int i = 0; i < vC; i++) {
            vip[sc.nextInt()] = true;
        }
        vip[n+1] = true;

        answer = 1;
        count = 0;
        for(int i = 1; i <= n+1; i++) {

            if(vip[i] || i ==n+1) {
                answer *= dp[count];
                count = 0;
            } else {
                count++;
            }

        }
        System.out.print(answer);




    }
}
