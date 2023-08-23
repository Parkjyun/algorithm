package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15665 {
    static int n;
    static int m;
    static int[] givenSet;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        givenSet = new int[n];
        answer = new int[m];

        for(int i = 0; i < n; i++) {
            givenSet[i] = sc.nextInt();
        }

        Arrays.sort(givenSet);
        dfs(0);
        System.out.println(sb);

    }
    static void dfs(int depth) {
        int before = 0;
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(before == givenSet[i]) continue;
            answer[depth] = givenSet[i];
            before = givenSet[i];
            dfs(depth + 1);
        }
    }
}
