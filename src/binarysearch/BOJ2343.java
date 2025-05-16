package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2343 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // n개의 강의
        int m = Integer.parseInt(st.nextToken()); // m개의 디비디

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max+= arr[i];
            min = Math.max(min, arr[i]);
        }

        int l = min;
        int h = max;

        while (l < h) {
            int mid = (l + h)/2;

            if (count(mid) <= m) {
                h = mid;
            } else {
                l = mid+1;
            }
        }
        System.out.println(l);
    }
    static int count(int num) {
        int sum = 0;
        int r = 1;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= num) {
                sum+=arr[i];
            } else {
                r++;
                sum = arr[i];
            }
        }
        return r;
    }
}
