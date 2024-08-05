package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int h = n - 1;
        int sum = 0;
        int limit = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = n - 1;
        while (l < h) {
            sum = arr[l] + arr[h];

            if (Math.abs(sum) <= limit) {
                limit = Math.abs(sum);
                answer1 = arr[l];
                answer2 = arr[h];
            }
            if (sum > 0) {
                h--;
            } else l++;
        }
        if (answer1 < answer2) System.out.println(answer1 + " " + answer2);
        else System.out.println(answer2 + " " + answer1);
    }
}
