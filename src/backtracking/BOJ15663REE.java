package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15663REE {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] arr;
    static int n, m;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];


        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        visited = new boolean[n];
        dfs(0);
        System.out.println(sb);


    }

    static void dfs(int depth) {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }


        int before = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;//벙뮨하지 않았고
            if (before == num[i]) continue;//같은 lv의 직전과 같다면
            before = num[i];

            visited[i] = true;
            arr[depth] = num[i];
            dfs(depth+1);;
            visited[i] = false;
        }
    }
}

