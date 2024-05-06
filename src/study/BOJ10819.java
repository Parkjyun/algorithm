package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10819 {
    static int n;
    static boolean[] visited;
    static int[] arr;
    static int[] ans;
    static int sum = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        ans = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(backtracking(0));
    }

    static int backtracking(int depth) {
        if (depth == n) {
            sum = 0;
            for (int i = 0; i < ans.length-1; i++) {
                sum += Math.abs(ans[i] - ans[i+1]);
            }
            max = Math.max(sum, max);
            return max;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {//이번 depth에서 해당 후보가 방문하지 않았다면
                ans[depth] = arr[i];
                visited[i] = true;
                backtracking(depth+1);
                visited[i] = false;
            }
        }
        return max;
    }
}
