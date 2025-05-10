package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13144 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        boolean[] visited = new boolean[100001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        long answer = 0;
        visited[arr[0]] = true;
        while (e <= n-1){
            if (e == n-1) {
                answer += (long)(e+1-s)*(e-s+2) / 2;
                break;
            }

            if (visited[arr[e+1]]) { //다음이 방문한 곳이라면
                answer += e+1 - s;
                visited[arr[s]] = false;
                s++;
            } else { // 새로 방문 한 곳이라면
                visited[arr[e+1]] = true;
                e++;
            }

        }

        System.out.println(answer);

    }
}
