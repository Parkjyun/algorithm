package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2473 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] answer = new int[3];
        long dif = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int l = i+1;
            int h = n-1;


            while (l < h) { // 각 while문 한번씩이 새 경우의 수
                long sum = (long)arr[i] + arr[l] + arr[h];
                if (Math.abs(sum) < dif) {
                    dif = Math.abs(sum);
                    answer[0] = arr[i];
                    answer[1] = arr[l];
                    answer[2] = arr[h];
                }
                if (sum > 0) {
                    h--;
                } else if (sum < 0) {
                    l++;
                } else {
                    System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
                    return;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
