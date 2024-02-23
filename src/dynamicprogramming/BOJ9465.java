package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465 {
    //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][s+1];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int l = 0; l < s; l++) {
                    stickers[j][l+1] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[2][s+1];
            dp[0][0] = 0;
            dp[1][0] = 0;
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int x = 2; x < s+1; x++ ) { // x : 0 - s = 5
                dp[0][x] = Math.max(dp[1][x-1], dp[1][x-2]) + stickers[0][x];
                dp[1][x] = Math.max(dp[0][x-1], dp[0][x-2]) + stickers[1][x];
            }
            int result = Math.max(dp[0][s], dp[1][s]);
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}
