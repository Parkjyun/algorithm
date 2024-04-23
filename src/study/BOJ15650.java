package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int[] arr;
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //1 부터 n까지의 수중에서 m개를 선택
        //수열 == 대상의 순서 있는 나열, 중복 없이 오름 차순으로
        arr = new int[n+1];
        visited = new boolean[n+1];
        answer = new int[m+1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        sb = new StringBuilder();
        backtracking(0);
        System.out.println(sb);
    }
    public static void backtracking(int depth) {
        while (depth == answer.length-1) {//m = 2
            for (int i = 1; i < answer.length; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i < arr.length; i++) {//모든 arr을 돌며
            if (!visited[i] && arr[i] > answer[depth]) {//방문하지 않았고 방문할 놈이 제일 최근 방문 한 놈보다 크다면
                visited[i] = true;
                answer[depth+1] = i;
                backtracking(depth+1);
                visited[i] = false;//다음 놈들을 위해 풀어줌
            }

        }

    }
}
