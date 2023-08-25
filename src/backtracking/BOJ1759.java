package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1759 {
    static int l;
    static int c;
    static char[] givenSet;
    static boolean[] visited;
    static char[] answer;
    static int countM;
    static int countJ;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        givenSet = new char[c];
        answer = new char[l];
        visited = new boolean[c];

        for(int i = 0; i < givenSet.length; i++) {
            givenSet[i] = sc.next().charAt(0);
        }
        Arrays.sort(givenSet);
        dfs(0,0);
        System.out.println(sb);
    }
    static void dfs(int depth, int start) {
        if(depth == l) {
            if (validation()) {
                for (int i = 0; i < answer.length; i++) {
                    sb.append(answer[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for(int i = start; i < givenSet.length; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                answer[depth] = givenSet[i];
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
    static boolean validation() {
        countM = 0;
        countJ = 0;
        for(int i  = 0; i < l; i++) {
            if(answer[i] == 'a') countM++;
            else if(answer[i] == 'e') countM++;
            else if(answer[i] == 'i') countM++;
            else if(answer[i] == 'o') countM++;
            else if(answer[i] == 'u') countM++;
            else countJ++;
        }
        if(countM >= 1 && countJ >= 2)
            return true;
        return false;
    }
}
