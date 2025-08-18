package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1103RE {
    static int dx[] = new int[] {0,1,0,-1};
    static int dy[] = new int[] {1,0,-1,0};
    static int dp[][];
    static int map[][];
    static boolean visited[][];
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        // 4방향중 한 방향으로
        // 바깥으로 나가거나 H면 게임 끝 오래하고 싶다.
        // 최대 몇번 게임 가능? 시작 00

        //max
        // 초기값 -1 => 가능하다면이라면 1 return
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dp = new int[n][m];
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            String in = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = in.charAt(j) - '0';
                if (!(map[i][j] <= 9 && map[i][j] >= 1)) {
                    map[i][j] = 0;
                }
            }
        }

        //무한번 움직일 수 있으면 -1
        int answer = dfs(0,0);
        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }


    }

    static int dfs(int x, int y) {

        if (dp[x][y] != -1) { // 이미 초기화가 되어 있다면
            return dp[x][y];
        }

        dp[x][y] = 0;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + map[x][y]*dx[i];
            int ny = y + map[x][y]*dy[i];

            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || map[nx][ny] == 0) continue;

            if (visited[nx][ny]) {
                flag = true;
            }
            dp[x][y] = Math.max(dfs(nx, ny), dp[x][y]);


        }
        visited[x][y] = false;


        dp[x][y]++;
        return dp[x][y];

    }
}
