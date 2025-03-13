package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //n개의 랜선으로 k개를 만들자.
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long l = 1;
        long h = max;
        long m;
        long answer = 0;
        while(l <= h) {
            m = l + (h-l)/2;

            long c = calculate(arr, m);

            if (c >= k) {
                answer = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        System.out.println(answer);
    }

    static long calculate(int[] arr, long m) {
        long count = 0;

        for (int i = 0; i < arr.length; i++) {
            count += arr[i] / m;
        }
        return  count;
    }
}
