package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {
    static int n;
    static int m;
    static int[] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        //1부터 n까지의 자연수 중에서 M개를 고른 수열
        // 같은 수를 여러 번 골라도 된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        answer = new int[m];

        dfs(0);
        System.out.println(sb);

    }

    static void dfs(int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            answer[depth] = i;
            dfs(depth + 1);
        }
    }
}
