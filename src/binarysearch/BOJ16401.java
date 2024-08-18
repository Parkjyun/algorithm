package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 조카의 수
        int n = Integer.parseInt(st.nextToken()); //과자의 수

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i  < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int l = 1;
        int h = arr[n-1];
        int count = 0;
        int answer = 0;
        while(l <= h) {
            count = 0;
            int mid = (l+h)/2;
            for (int i = 0; i < n; i++) {
                count += arr[i] / mid;
            }
            if (count < m) {
                h = mid - 1;
            } else { // m명에게 나눠줄 수 있다면
                answer = mid;
                l = mid+1;
            }
        }
        System.out.println(answer);

    }
}
