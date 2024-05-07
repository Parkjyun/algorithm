package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15656 {
    static int n, m;
    static int[] arr, ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ans = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtracking(0);
        System.out.println(sb);
    }
    static void backtracking(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }
        //1789 -> 모두 다른 수 보장
        //n개의 자연수 중에서 m개를 고른 수열
        //같은 수를 여러 번 골라도 된다.
        //증가순으로
        // 11 17 18 19 71 77 78 79
        for (int i = 0; i < n; i++) {
            ans[depth] = arr[i];
            backtracking(depth+1);
        }
    }
}
