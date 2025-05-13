package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11725 {
    static boolean[] visited;
    static int[] answer;
    static List<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        adj = new List[n+1];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        StringTokenizer st;

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        visited = new boolean[n+1];
        answer = new int[n+1];

        dfs(1);
        for (int i = 2; i < n+1; i++) {
            System.out.println(answer[i]);
        }
    }
    static void dfs(int start) {//index기반
        visited[start] = true;

        for (int to : adj[start]) { //to 는 인접 노드
            if (visited[to]) continue;
            if (to == start) continue;
            answer[to] = start;
            dfs(to);
        }

    }
}
