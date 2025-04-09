package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1103 {
    static int n, m;
    static boolean visited[][];
    static int dp[][];// 마지막에서부터 몇번째인가?
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static char map[][];
    static boolean cycle = false;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n+1][m+1];
        dp = new int[n+1][m+1];
        //dp[x][y]란 xy점에서 최데 먗반의 게임을 할 수 있냐? h또는 범위 아웃이면 0을 반환한다.
        visited = new boolean[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = s.charAt(j-1);
            }
        }

        dfs(1,1);
        System.out.println(dp[1][1]);





    }
    static int dfs(int x, int y) {
        if (!isIn(x, y)) return 0;//범위 나가면 그냥 0
        if (map[x][y] == 'H') return 0;
        if (visited[x][y]) {//사이클이 생긴다면 그냥 -1출력하고 꿑
            cycle = true;
            System.out.println(-1);
            System.exit(0);
        }
        if (dp[x][y] > 0) return dp[x][y];

        for (int i = 0; i < 4; i++) {//내 방향중 최대를 얻겠다.
            int value = map[x][y] - '0';
            int nx = x + dx[i] * value;
            int ny = y + dy[i] * value;
            visited[x][y] = true;
            dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);//나 자신 or 내 방향중 최대 + 1을
            visited[x][y] = false;
        }

        return dp[x][y];

    }

    static boolean isIn(int x, int y) {
        if (x <= 0 || y <= 0 || x > n || y > m) return false;
        return true;
    }
}
