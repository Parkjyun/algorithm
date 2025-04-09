package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686RE {
    static int map[][];
    static boolean visited[][];
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> home = new ArrayList<>();
    static List<int[]> selected = new ArrayList<>();
    static int n, m;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    chicken.add(new int[] {i,j});
                }
                if (map[i][j] == 1) {
                    home.add(new int[] {i,j});
                }
            }
        }
        dfs(0, 0);
        System.out.println(answer);

    }

    static void dfs(int depth, int start) {
        if (depth == m) {//다 뽑았다면
            int sum = 0;
            for (int[] h : home) {
                int cd = Integer.MAX_VALUE;
                for (int[] s : selected) {
                    cd =  Math.min(Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]), cd);
                }
                sum += cd;
            }
            answer = Math.min(sum, answer);
        }

        for (int i = start; i < chicken.size(); i++) {
            selected.add(chicken.get(i));
            dfs(depth+1, i+1);
            selected.remove(chicken.get(i));
        }
    }
}
