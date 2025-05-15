package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] given = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            given[i][0] = Integer.parseInt(st.nextToken()); // w
            given[i][1] = Integer.parseInt(st.nextToken()); // v
        }

        int[][] dp = new int[n+1][w+1];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {

                                        //i+1번째
                if (j >= given[i][0]) {
                    dp[i+1][j] = Math.max(dp[i][j], dp[i][j - given[i][0]] + given[i][1]);
                } else {
                    dp[i + 1][j] = dp[i][j];

                }
            }
        }
        System.out.println(dp[n][w]);
    }
}
