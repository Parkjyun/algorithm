package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        //1 - n 자연수 중에서 중복 없이 m개를 고른 수열
        // 오름차순
        // 4,2 -> 12, 13, 14 23 24 34

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n];

        dfs(n, m, 0, 0);
    }

    static void dfs(int n, int m, int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(n, m,i, depth + 1);
                visited[i] = false;
            }
        }

    }
}
