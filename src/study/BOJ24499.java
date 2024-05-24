package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ24499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[2*n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        for (int i = n+1; i < 2*n + 1; i++) {
            arr[i] = arr[i-1] + arr[i-n] - arr[i-n-1] ;
        }
        int max = 0;
        for (int i = 0; i < 2*n + 1; i++) {
            if (i == n) break;
            max = Math.max(max, arr[i+k] - arr[i]);
        }
        System.out.println(max);
    }
}
