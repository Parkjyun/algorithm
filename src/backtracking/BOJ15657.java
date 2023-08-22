package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15657 {
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

        for(int i = 0; i < givenSet.length; i++)
            givenSet[i] = sc.nextInt();
        Arrays.sort(givenSet);
        dfs(0,0);

        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if(depth == m) {
            for(int i = 0; i < answer.length; i++)
                sb.append(answer[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = start; i < givenSet.length; i++) {
            answer[depth] = givenSet[i];
            dfs(depth + 1, i);
        }
    }
}
