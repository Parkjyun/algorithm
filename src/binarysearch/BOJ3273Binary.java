package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273Binary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int obj = Integer.parseInt(br.readLine());
        int answer = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > obj/2) continue;
            if (binarySearch(arr, obj - arr[i], i+1)) answer++;
        }
        System.out.println(answer);
    }

    static boolean binarySearch(int[] arr, int find, int start) {//start는 본인 +1
        int l = start;
        int h = arr.length - 1;

        while (l <= h) {
            int m = l + (h-l) / 2;
            if (arr[m] < find) {
                l = m+1;
            } else if (arr[m] > find) {
                h = m-1;
            } else return true;
        }
        return false;
    }
}
