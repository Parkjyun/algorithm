package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//n개의 랜선으로 길이가 최대인 m개의 랜선을 구해야한다.
        int obj = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long l = 1;
        long h = arr[n-1];
        long answer = 0;
        while (l <= h) {
            long mid = (l + h)/2;// 기준
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum+= arr[i]/mid;
            }
            if (sum == obj) {

                l = mid+1;
                answer = mid;

            } else if (sum > obj) { // 갯수가 많다면 -> 기준 높여
                l = mid+1;
                answer = mid;
            } else { // 갯수가 적다면 -> 기준 줄여
                h = mid-1;
            }
        }
        System.out.println(answer);
    }
}
