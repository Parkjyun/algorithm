package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long obj = Long.parseLong(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int h = 0;
        int sum = 0;
        int answer = 0;
        while (l < n) {
            if (sum > obj || h == n) {
                sum -= arr[l];
                l++;
            } else if(sum < obj) {
                sum += arr[h];
                h++;

            }
            if (sum == obj) {
                sum -= arr[l];
                l++;
                answer++;
            }
        }
        System.out.println(answer);

    }
}
