package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int n;
    public static void main(String[] args) throws IOException {
        // 만약 팀에 123이 있다면 12 13 21 23 31 32 -> np2
        // 능력치 차이 최소로
        // 1. 20명을 두개의 그룹으로 == 2의 20 승 == 1000 000 == 백만 하고 각각에 대해 합을 구한다. if depth = 10
        // 백만 * 10명에 대해 10p2 = 10 9 = 90 ==

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);

    }

    static void dfs(int depth, int start) {
        if (depth == n/2) { // n명을 다 배치했다면 // visited n명 중에서
            int team1 = 0;
            int team2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        team1+=map[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        team2+=map[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(team1 - team2));

            // 나느기
            return;
        }

        for (int i = start; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(depth+1, i+1);
            visited[i] = false;
        }
    }
}
