package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2473 {
    static int[] arr;
    static int[] answer = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long curDif = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int l = j+1;
                int h = n-1;
                int m;

                while (l <= h) {
                    m = l + (h-l)/2;
                    long sum = (long)arr[i] + arr[j] + arr[m];
                    if (Math.abs(sum) < curDif) {
                        curDif = Math.abs(sum);
                        answer[0] = arr[i];
                        answer[1] = arr[j];
                        answer[2] = arr[m];
                    }
                    //합이 0인가를 찾아가면서 이분탐색을 하면서 가장 optimal을 매 회차자맏 저장
                    if (sum < 0) { // sum = 0 == sum = -(arr[i] + arr[j])
                        l = m+1;
                    } else if (sum > 0) {
                        h = m-1;
                    } else {
                        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
                        return;
                    }
                }

            }
        }
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);

    }
}
