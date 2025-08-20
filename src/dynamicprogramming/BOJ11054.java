package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp1[0] = 1;
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j]);
                }
            }
            dp1[i]++;
        }
        int answer = Integer.MIN_VALUE;
        dp2[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            for (int j = n-1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dp2[i] = Math.max(dp2[j], dp2[i]);
                }
            }
            dp2[i]++;
        }
        for (int i = 0; i < n; i++) {
            answer = Math.max(dp1[i]+ dp2[i], answer);
        }
        System.out.println(answer-1);

    }
}
