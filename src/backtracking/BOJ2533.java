package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2533 {
    static List<List<Integer>> map = new ArrayList<>();
    static int[][] dp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        //ea, node num이라는 상태가 존재 -> dp
        // 아래 정보를 알아야 dp점화식 계산 가능 -> 서브 트리부터 후위
        // dp[n][0,1] -> n번째 노드가 0(ea), 1(eax)일 때 필요한 최소한의 ea수

        /*
        dp[n][0] = ea -> 아래는 ea eax둘다 가능    dp[n][0] = 1 + sum(min(dp[자식][0], dp[자식][1]))
        dp[n][1] = eax -> 아래는 전부 ea 여야함 dp[n][1] = sum(dp[자식][0])
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][2];
        visited = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        //트리니까 루트는 1이라 걍 가정
        visited[1] = true;
        solve(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    static void solve(int start) {
        dp[start][0] = 1;//ea // 초기값 지정 리프 노드는 어차피 자식 없으니까 이대로 올라오겠지??
        dp[start][1] = 0;

        for (int c : map.get(start)) {
            if (!visited[c]) {// 현재 트리는 무방향 그래프 -> 부모는 visited -> dp 하지 않아
                visited[c] = true;
                solve(c);
                dp[start][0] += Math.min(dp[c][0], dp[c][1]);
                dp[start][1] += dp[c][0];
            }
        }
    }
}
