package programmers.dp;

import java.util.Arrays;

public class 코딩테스트공부  {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;

        int ma = Integer.MIN_VALUE;// 최대 req
        int mc = Integer.MIN_VALUE;// 최대 req
        for (int[] p : problems) {
            ma = Math.max(ma, p[0]);
            mc = Math.max(mc, p[1]);
        }
        if (alp >= ma && cop >= mc) return 0;
        if (alp >= ma) {
            alp = ma;
        }
        if (cop >= mc) {
            cop = mc;
        }
        int[][] dp = new int[ma+1][mc+1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE-10000);
        }
        dp[alp][cop] = 0;

        for (int i = alp; i <= ma; i++) {
            for (int j = cop; j <= mc; j++) {
                if(i == ma && j ==mc) continue;

                dp[i+1>= ma ? ma : i+1][j] = Math.min(dp[i+1>= ma ? ma : i+1][j], dp[i][j] + 1);
                dp[i][j+1 >= mc ? mc : j+1] = Math.min(dp[i][j+1 >= mc ? mc : j+1], dp[i][j] + 1);

                for (int a = 0; a < problems.length; a++) {
                    if (i >= problems[a][0] && j >= problems[a][1]) {//점수가 가능하다면
                        int x = Math.min(ma, i + problems[a][2]);
                        int y = Math.min(mc, j + problems[a][3]);
                        dp[x][y] = Math.min(dp[x][y], dp[i][j] + problems[a][4]);
                    }
                }
            }
        }
        return dp[ma][mc];
    }
}
