package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            bs(arr, Integer.parseInt(st.nextToken()));
        }
        System.out.println(sb);
    }
    static void bs(int[] arr, int find) {
        int l = 0;
        int h = arr.length-1;
        int mid = (l+h)/2;
        while (l <= h) {

            if (arr[mid] == find) {
                sb.append(1 + " ");
                break;
            }
            else if (arr[mid] < find) { // 찾는 것이 Mid보다 크다면
                l = mid + 1;
                mid = (l + h)/2;
            } else {
                h = mid -1;
                mid = (l + h)/2;
            }
        }
        if (arr[mid] != find) sb.append(0).append(" ");

    }
}
