package binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {//j + find = i
                if (j == i) continue;
                int find = arr[i] - arr[j];
                int res = binarySearch(find, arr, i, j);//find의 index
                if ( res!= -1) {//찾았다.
                    if (res == j || res == i) continue;
                    answer++;
                    break;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
    private static int binarySearch(int find, int[] arr, int i, int j) {
        int l = 0;
        int h = arr.length-1;
        while (l <= h) {
            int m = (l+h) / 2;
            if (arr[m] > find) { // 찾는 놈이 중앙보다 작다면
                h = m-1;
            } else if (arr[m] < find) {
                l = m+1;
            } else {//찾았느넫
                if (m == i || m == j) {
                    l++;
                    continue;
                }
                return m;
            }
        }
        return -1;
    }
}
