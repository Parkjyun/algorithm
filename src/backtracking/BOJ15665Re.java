package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15665Re {
    //같은 수를 여러번 골라도 된다.
    //하지만 같은 수열을 여러번 출력하면 안된다.
    // 증가하는 순으로
    static int[] answer;
    static int n;
    static int m;
    static int[] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[m];
        map = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map); //오름차순 정렬
        dfs(0);
        System.out.println(sb);

    }

    static void dfs(int depth) {
        if(depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }
        int before = 0; // 이번 depth에서 사용할 before
        for (int i = 1; i <= n; i++) {
            if (before != map[i-1]) { // 이번 depth에서 이전 값과 이번 값이 같다면 무시한다.
                before = map[i-1];
                answer[depth] = map[i-1];
                dfs(depth + 1);
            }
        }
    }
}
