package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[2];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int l = 0;
        int r = n - 1;
        int sum;
        int min = Integer.MAX_VALUE;

        while (l < r) {

            sum = arr[l] + arr[r];

            if (sum == 0) {
                result[0] = arr[l];
                result[1] = arr[r];
                break;
            }

            if (min > Math.abs(sum)) {//새로운 최소라면
                result[0] = arr[l];
                result[1] = arr[r];
                min = Math.abs(sum);
            }

            if (sum < 0)
                l++;
            else
                r--;
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
