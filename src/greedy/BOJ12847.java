package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        long answer = sum;
        for (int i = 0; i < n - m; i++) {
            sum -= arr[i];
            sum += arr[i + m];
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
