package dynamicprogramming;

import java.util.Scanner;
//|,길이가 n인 직사각형을 1*2, 2*1로 채우는 방법의 수는?
//가로는 생각하지 않다고 된다
//그냥 n을 1과2의 합으로 표현하면 된다 -> 저절로 채워지기 때문에
//고로 n을 1과 2의 합으로 표현하는 경우의 수를 구하는 문제 -> 중복가능 but 순서 상관 있다.
//dp== 길이 n인 선을 1,2로 표현하는 조하븨 수
//dp[1] = 1
//dp[2] = 2 (11,2)
//dp[3] = 3 (111. 21, 12)
//dp[4] = 5 (1111 112 121 211 22)
//dp[5] = 8 (11111, 1112, 1121, 1211, 2111, 122, 212, 221)
//dp[6] = 13 (111111, 11112, 11121,11211,12111,21111, 1122 ->6, 222 1)
//dp[n] = dp[n-1] + dp[n-2]
public class BOJ11726 {
    static int n;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.print(dp[n]);

    }
}
