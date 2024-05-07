package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15666 {
    static int n,m;
    static int arr[];
    static int ans[];
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
        backtracking(0,0);
        System.out.println(sb);
    }
    //n개의 자연수 중에서 m개를 고른 수열
    // 같은 수를 여러번 골라도 된다 -> visited를 할 필요가 없다.
    // 고른 수열은 비내림차순이어야 한다. a1 <= a2 <= a3<=
    static void backtracking(int start, int depth) {
        int recent = 0;
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (arr[i] == recent) continue;//이번에 정답에 넣을 후보와 이전 loop의 num이 같다면 continue
            ans[depth] = arr[i];
            backtracking(i ,depth+1);//해당 케이스가 끝나면
            recent = arr[i];//가장 최신에 방문한 놈은 arr[i]이다.
        }
    }
}
