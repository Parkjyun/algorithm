package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {
    static int n;
    static int m;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

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

        for (int i = 1; i <=n; i++) {
            if (depth == 0 || answer[depth-1] <= i) {
                answer[depth] = i;
                dfs(depth+1);
            }
        }
    }
}
