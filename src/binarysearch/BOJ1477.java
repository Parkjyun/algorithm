package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+2];
        arr[0] = 0;
        arr[n+1] = l;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int low = 1;
        int high = l-1;
        int answer = 0;
        while (low <= high) {
            int mid = (high+low)/2;//휴게소가 없는 구간의 최댓값
            int count = 0;
            for (int i = 1; i < arr.length; i++) {
                int interval = arr[i] - arr[i-1];
                count += interval / mid;
                if (interval % mid == 0) count--;
            }
            if (count > m) { //만약 mid가 작다면 -> 최댓값이 아님
                low = mid + 1;
            }
            else {//만약 mid가 크다면 -> mid를 줄여야지
                answer = mid;
                high = mid -1;
            }
        }
        System.out.println(answer);

    }
}
