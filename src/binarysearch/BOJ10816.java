package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10816 {
    //upperbound = 추가했을 때 오름차순이 깨지지 않는 가장 뒤의 idz
    // lowerbound = 추가했을 때 오름차순이 깨지지 않는 가장 앞의 idx
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upper(arr, target) - lower(arr, target)).append(" ");
        }
        System.out.println(sb);

    }

    static int lower(int[] arr, int target) {
        int l = 0;
        int h = arr.length;
        int m;
        while (l < h) {
            m = l + (h-l)/2;

            if (arr[m] < target) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }

    static int upper(int[] arr, int target) {
        int l = 0;
        int h = arr.length;
        int m;
        while (l < h) {
            m = l + (h-l)/2;

            if (arr[m] <= target) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;

    }
}
