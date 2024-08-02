package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(arr[i], max);
        }
        int limit = Integer.parseInt(br.readLine());
        if (sum <= limit) {
            System.out.println(max);
            return;
        }
        //만약 최댓값을 따로 구해야 한다면
        Arrays.sort(arr);
        //parameterized bs
        int answer = 0;
        int l = 1;
        int h = arr[n-1];
        while (l <= h) {
            int m = (l+h)/2;
            int s = 0;
            for (int i = 0; i < n; i++) {
                s += Math.min(m, arr[i]);//상한과 요소 중 작은 값을 기준으로 합을 구함
            }
            if (s == limit) {
                answer = m;
                break;
            } else if (limit > s) { //예산이 남는다면 상한을 늘리자
                l = m+1;
                answer = m;
            } else {//예산을 초과한다면 상한을 줄이자
                h = m-1;
            }
        }
        System.out.println(answer);

    }
}
