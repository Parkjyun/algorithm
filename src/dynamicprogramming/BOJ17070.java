package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];

        StringTokenizer st;
        for (int i = 1; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] dp = new int[n+1][n+1][3];

        dp[1][2][0] = 1;
        //012 -> 오 대아 아
        for (int i = 1; i < map.length; i++) { //x
            for (int j = 3; j < map.length; j++) { //y
                if (map[i][j] == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][2] = 0;
                } else {
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
                    dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];
                }

                if (map[i][j] == 1 || map[i-1][j] == 1 || map[i][j-1] == 1) {
                    dp[i][j][1] = 0;
                } else {
                    dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }

            }
        }
        System.out.println(dp[n][n][0] + dp[n][n][1]+dp[n][n][2]);
    }
}
