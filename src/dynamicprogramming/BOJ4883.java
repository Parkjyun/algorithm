package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (true) {
            count++;
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int[][] gs = new int[n][3];
            int[][] dp = new int[n][3];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }//초기화 완료
            //dp[i][j] i,j에서의 최단거리의 값
            //첫번째 행, 이후행 dp 배열 저장법이 다름
            for (int i = 1; i < n; i++) {
                if (i == 1) {
                    dp[i][0] = dp[i-1][1] + dp[i][0];
                            dp[i][1] = dp[i][1] + Math.min(Math.min(dp[i-1][1], dp[i-1][1] + dp[i-1][2]), dp[i][0]) ;
                            dp[i][2] = dp[i][2] + Math.min(Math.min(dp[i-1][2] + dp[i-1][1], dp[i-1][1]), dp[i][1]);
                } else {
                    for (int j = 0; j < 3; j++) {
                        if (j == 0) dp[i][j] = dp[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
                        if (j == 1) dp[i][j] = dp[i][j] + Math.min(Math.min(Math.min(dp[i-1][0], dp[i-1][1]), dp[i-1][2]), dp[i][0]);
                        if (j == 2) dp[i][j] = dp[i][j] + Math.min(Math.min(dp[i-1][1], dp[i-1][2]), dp[i][1]);
                    }
                }
            }
            System.out.println(count + ". " + dp[n-1][1]);
        }


    }
}
