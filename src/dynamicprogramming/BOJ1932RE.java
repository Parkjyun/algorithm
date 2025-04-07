package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932RE {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][];
        int[][] dp = new int[n+1][];

        StringTokenizer st;
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = new int[i+1];
            dp[i] = new int[i+1];// 1레벨 -> 2개 1부터
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dp 1-n이다
        dp[1][1] = map[1][1];

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i-1][j] + map[i][j];
                } else if (j == dp[i].length -1) {
                    dp[i][j] = dp[i-1][j-1] + map[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1] + map[i][j], dp[i-1][j] + map[i][j]);
                }

            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp[n].length; i++) {
            max = Math.max(max, dp[n][i]);
        }
        System.out.println(max);
    }
}
