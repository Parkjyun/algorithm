package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1520RE {
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(dfs(0,0));

    }

    static int dfs(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        if (x == map.length - 1 && y == map[0].length - 1) {
            return 1;
        }
        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
            if (map[x][y] > map[nx][ny]) { // 작아서 가능!
                dp[x][y] += dfs(nx,ny);
            }
        }
        return dp[x][y];
    }
}
