package dynamicprogramming;

import java.util.Scanner;

public class BOJ2240 {
    static int n;//총 횟수
    static int m;// 움직임
    static int[][][] dp;//힙에 생성 모두 0으로 초기화
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dp = new int[n+1][m+1][3];//초, 움직인 횟수, 사람의 위치
        for(int i = 1; i <=n; i++) {//1초 ~ n초에서
            int tree = sc.nextInt();//해당 초에 자두가 떨어지는 나무가 주어진다 1or 2
            for(int j = 0; j <= m; j++) {//0번~m번 움직인 상태가 존재한다
                if(j == 0) {//움직이지 않았다면 == 사람은 1에 있다
                    if(tree == 1) {//1에서 자두가 내려온다면
                        dp[i][j][1] = dp[i - 1][j][1] + 1;
                    }
                    continue;
                }

                if(tree == 1) {//만약 i초에 자두가 1에서 떨어진다면
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1]);


                } else if(tree == 2) {//만약 i초에 자두가 2에서 떨어진다면
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]);
                    dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1]) + 1;

                }


            }

        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= m; i++) {
            for(int j = 1; j <=2 ; j++) {
                if(dp[n][i][j] > max)
                    max = dp[n][i][j];//마지막초에 대해 12자리에 대해 movement 01234...m모두 조사, 최대를 출력
            }
        }
        System.out.print(max);
    }
}
