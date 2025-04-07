package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2240RE {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][][] dp = new int[t + 1][w + 1][3];
        //dp[초][움직인횟수][사람위치] = t초에 w번 움직였을 때 1번에 있는 경우, 2번에 있는 경우 먹은 자두의 수는
        // 움직여서 먹을때와 그 자리에서 먹을 때중 큰 것음??
        // dp[t][w][1] = dp[t-1][w][1], dp[t-1][w-1][2]
        // dp[t][w][2] = dp[t-1][w][2], dp[t-1][w-1][1];


        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= t; i++) { // 1초부터 t초까지
            int tree = Integer.parseInt(br.readLine());
            for (int j = 0; j <= w; j++) { // 0번부터 w번까지 이동할 수 있음
                if (tree == 1) {
                    if (j == 0) {//자리 안 움직엿다면
                        dp[i][j][1] = dp[i-1][j][1] + 1;
                        continue;
                    }
                    //i초에 j번 움작였는데 1번에 떨어진다.
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1]);

                } else if (tree == 2) {
                    if (j == 0) {
                        dp[i][j][2] = dp[i-1][j][2];
                        continue;
                    }
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]);
                    dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1]) + 1;
                }
            }

        }
        for (int j = 0; j <= w; j++) {
            answer = Math.max(Math.max(dp[t][j][1], dp[t][j][2]), answer);
        }
        System.out.println(answer);
    }
}
