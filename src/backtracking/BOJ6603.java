package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ6603 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        //s는 집합
        //k는 집합의 크기. 가능한 모든 조합을 사전순으로 출력하라.
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {//0이 아니라면 계속한다.
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            arr = new int[n+1];
            visited = new boolean[n+1];
            answer = new int[6];

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(1,0);
            System.out.println();

        }



    }
    static void dfs(int before, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }
         // 각각의 depth마다
        for (int i = before; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                dfs(i, depth + 1);
                visited[i] = false;
            }

        }
    }
}
