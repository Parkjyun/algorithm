package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//접시수
        int var = Integer.parseInt(st.nextToken()); // 초밥 가시수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰번호

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //sliding window
        int[] visited = new int[var+1];//가지는 1부터
        int count = 1; //이번 회차의 가지수
        visited[c] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {//처음 한줄
            if (visited[arr[i]] == 0) {
                count++;
            }
            visited[arr[i]]++;
        }
        max = Math.max(max, count);

        for (int i = 1; i < n; i++) {

            visited[arr[i-1]]--;//이전꺼 뺀다
            if (visited[arr[i-1]] == 0) count--;//빼서 0이라면 가지수 뺀다
            if (visited[arr[(i+k-1)%n]] == 0) count++;visited[arr[(i+k-1)%n]]++;
            max = Math.max(max, count);

        }


        System.out.println(max);
    }
}
