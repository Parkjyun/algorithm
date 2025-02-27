package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ15649 {
    //각 시행에서 사용한 숫자를 체크하기 위한 배열
    static boolean[] visited;
    // 수열을 저장하기 위한 배열
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 총 3개의 숫자 중에서
        int m = Integer.parseInt(st.nextToken()); // m개를 고르겠다.
        visited = new boolean[n];
        arr = new int[m];

        //1부터 n까지의 자여수 중에서 중복 없이 m개를 고른 수열의 개수를 찾아라
        dfs(n, m, 0);

    }

    static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i+1;
                dfs(n, m, depth + 1);
                visited[i] = false;
            }
        }

    }
}
