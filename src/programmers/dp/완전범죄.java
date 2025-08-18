package programmers.dp;

import java.util.Arrays;

public class 완전범죄 {
    public int solution(int[][] info, int n, int m) {

        int[][] dp = new int[info.length+1][121];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE/2);
        }
        dp[0][0] = 0;

        for (int i = 1; i < info.length+1; i++) {//각 물건

            for (int j = 0; j < dp[i].length; j++) {//모든 b돌며

                if (j + info[i-1][1] < m) {//b추가가능
                    dp[i][j + info[i-1][1]] = Math.min(dp[i-1][j], dp[i][j + info[i-1][1]]);
                }
                if (info[i-1][0] + dp[i-1][j] < n) { // a 추가가능
                    dp[i][j] = Math.min(info[i-1][0] + dp[i-1][j], dp[i][j]);
                }

            }
        }
        int answer = Integer.MAX_VALUE/2;
        for (int j = 0; j < dp[0].length; j++) {
            answer = Math.min(answer, dp[info.length][j]);
        }
        return answer == Integer.MAX_VALUE/2 ? -1 : answer;

    }
}