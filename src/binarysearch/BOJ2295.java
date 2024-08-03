package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] twoSum = new int[n*(n+1)/2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                twoSum[index++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(twoSum);
        Arrays.sort(arr);
        int answer = 0;
        for (int i = n-1; i > 0 ; i--) {
            for (int j = 0; j <= n-1; j++ ) {
                int find = arr[i] - arr[j];
                if (Arrays.binarySearch(twoSum, find) >= 0) { //존재한다면
                    answer = Math.max(answer, arr[i]);
                }
            }
        }
        System.out.println(answer);
    }
}
