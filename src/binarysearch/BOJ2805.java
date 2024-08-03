package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int l = 0;
        int h = arr[n-1];
        int answer = 0;
        while (l <= h) {
            int m = (l+h) / 2;

            long sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += Math.max(arr[i] - m, 0);
            }

            if (sum == limit) {
                answer = m;
                break;
            } else if (sum > limit) {
                l = m+1;
                answer = m;
            } else if (sum < limit) {
                h = m-1;
            }
        }
        System.out.println(answer);

    }
}
