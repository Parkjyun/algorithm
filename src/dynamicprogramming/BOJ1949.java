package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1949 {
    static int n;
    static List<Integer>[] adj;
    static int[][] dp;
    static boolean[] visited;
    static int[] people;
    public static void main(String[] args) throws IOException {
        //root node 주어지지 않음 -> 단뱡향 탐색하면서 아래 depth로 만 내려가면 안 됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        people = new int[n+1];
        visited = new boolean[n+1];

        adj = new List[n+1]; //adj[출발마을번호]
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }
        dp = new int[n+1][2];
//        for (int i = 0; i < dp.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            adj[to].add(from);
        }

        //adj
        //d
        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int start) { // start에서 choose에 따른 최대 인원수를 return한다.
        dp[start][1] = people[start];
        visited[start] = true;
        for (int to : adj[start]) { // from은 start에서 올수 있는 곳
            if (visited[to]) continue;
            dfs(to);
            dp[start][0] += Math.max(dp[to][0], dp[to][1]);
            dp[start][1] += dp[to][0];
        }
        visited[start] = false;
    }
}
