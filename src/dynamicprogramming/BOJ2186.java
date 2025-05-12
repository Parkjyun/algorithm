package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2186 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][][] dp;
    static boolean[][] visited;
    static String obj;
    static char[][] map;
    static int n,m, k;
    public static void main(String[] args) throws IOException {
        //메모이제이션 쓰지 않으면 최악 n*m * 20^80
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        obj = br.readLine();

        //dp배열 초기화
        // 만약 두개의 경로가 있고 각각의 경로가 depth에서 (2,1)에서 합쳐져서 목적지까지 같은 경로로 간다면 dp에는 해당 점에서 목적지까지 갈 수 있는 경우의 수
        dp = new int[n][m][obj.length()];
        for (int[][] arr : dp) {
            for (int[] arr2 : arr) {
                Arrays.fill(arr2, -1);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == obj.charAt(0)) {
                    answer += dfs(0, i,j);
                }
            }
        }
        System.out.println(answer);
    }
    static int dfs(int depth, int x, int y)  {
        if (depth == obj.length()-1) { //단어 완성
            return 1;
        }
        if (dp[x][y][depth] != -1) return  dp[x][y][depth]; // 이전에 방문한 곳이라면

        dp[x][y][depth] = 0; // 최초 i,j에 대한 초기화
        for (int j = 1; j <= k; j++) {
            for (int i = 0; i < 4; i++) {
                int nx = x + j*dx[i];
                int ny = y + j*dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (map[nx][ny] == obj.charAt(depth+1)) { // obj에 맞는 다음 문자열일때만
                    dp[x][y][depth] += dfs(depth+1, nx,ny);
                }
            }
        }
        return dp[x][y][depth];//단어 완성도 아니고 이전에 방문한 곳도 아니면 가능한 모든 점들 돌면서 dp쌓아서 반환(= xy depth에서 가능한 경로의 수)
    }
}
