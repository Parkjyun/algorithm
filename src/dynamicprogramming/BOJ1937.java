package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1937 {
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i,j));
            }
        }
        System.out.println(max);

    }
    static int dfs(int x, int y) {
        if(dp[x][y] != -1) return dp[x][y];

        //더 갈수 없다면
        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length) continue;
            if (map[x][y] < map[nx][ny]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx,ny));
            }
        }
        dp[x][y]++;

        return dp[x][y];
    }
}
