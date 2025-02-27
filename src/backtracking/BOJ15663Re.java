package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ15663Re {
    static int n;
    static int m;
    static int[] answers;
    static int[] map;
    static boolean[] visited;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        //주어진 수열에서 m개를 고른 수열을 찾아라, 만약 99라면 9a, 9b만 가능 하나일 때는 두번 불가능

        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answers = new int[m];
        map = new int[n];


        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);

        dfs(0, 0);
        System.out.println(sb);

    }

    static void dfs(int prev, int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(answers[i] + " ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
//이번 depth에서는 그만 보자
        for (int i = 0; i < n; i++) {
            if(!visited[i] && before != map[i]) { // 방문하지 않았고 직전이랑 이번 것이 다르다면 들어간다.
                visited[i] = true;
                before = map[i];
                answers[depth] = map[i];
                dfs(map[i], depth + 1);//여기 가면 새로운 depth로 들어가면서 before가 0으로 된다. 즉 새로운 depth에서는 같은 수 가능 같은 depth에서는 같은 수 불가능
                visited[i] = false;
            }
        }

    }
}
