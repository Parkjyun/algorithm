package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805RE {
    public static void main(String[] args) throws IOException {
        //n m
        // 나무의 길이.
        //백만
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());//n개의 나무
        int m = Integer.parseInt(st.nextToken());//적어도 m미터의 나무를 가져가야함

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int h = arr[n-1];
        int l = 0;
        int mid;
        int answer = 0;
        while (l <= h) {
            mid = l + (h-l)/2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    sum += arr[i] - mid;
                }
            }
            if (sum < m) {
                h = mid-1;
            } else {
                answer = mid;
                l = mid+1;
            }

        }
        System.out.println(answer);
    }
}
