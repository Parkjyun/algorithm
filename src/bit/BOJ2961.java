package bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ2961 {
    static int f[][];
    static boolean[] set;
    static int answer = Integer.MAX_VALUE;
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        f = new int[n][2];
        set = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            f[i][0] = Integer.parseInt(st.nextToken()); // 신맛
            f[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
        }

        dfs(0);
        System.out.println(answer);

    }

    static void dfs(int depth) {//부분집합을 만들 것임
        if (depth == n) {
            int count = 0;
            for (int i = 0; i < set.length; i++) {
                if (set[i]) count++;

            }
            if (count == 0) return;

            answer = Math.min(answer, calculate());
            return;
        }

        set[depth] = true;
        dfs(depth + 1);

        set[depth] = false;
        dfs(depth + 1);

    }

    static int calculate() {
        int sour = 1;
        int bitter = 0;
        for (int i = 0; i < set.length; i++) {
            if (set[i]) {
                sour *= f[i][0];
                bitter += f[i][1];

            }
        }
        return Math.abs(sour - bitter);
    }
}
