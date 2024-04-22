package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] tofind = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < tofind.length; i++) {
            tofind[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);

        for (int i = 0; i < tofind.length; i++) {
            sb.append(binarySearch(arr, tofind, i) + "\n");
        }
        System.out.println(sb);
    }
    private static int binarySearch(int[] arr, int[] tofind, int i) {
        int start = 0;
        int mid;
        int end = arr.length-1;
        while (start <= end) {
            mid = start + (end-start)/2;
            if (tofind[i] < arr[mid]) {
                end = mid -1;
            } else if (tofind[i] > arr[mid]) {
                start = mid + 1;
            } else return 1;

        }
        return 0;
    }
}
