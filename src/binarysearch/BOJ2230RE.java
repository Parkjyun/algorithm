package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int index = lb(arr, arr[i] + m);
            if (index >= arr.length) continue;
            min = Math.min(min, arr[index] - arr[i]);
        }
        System.out.println(min);
    }

    public static int lb(int[] arr, int key) {
        int l = 0;
        int h = arr.length;

        while (l < h) {
            int m = l + (h-l)/2;

            if (arr[m] >= key) {
                h = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
}
