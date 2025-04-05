package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        //슬라이딩 윈도우임
        // s와 i가 있다.
        // 합이 s보다 작다면 end++
        // 합이 s보다 크다면 min 갱신 및 s++

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        //10 기준 99까지 돌린다 10 9 break
        // 1,0 은 하나
        while (end <= n && start <= n) {
            if (sum < s) {
                end++;
                sum +=arr[end-1];
            } else if (sum >= s) {
                start++;
                sum -= arr[start-1];

            }

            System.out.println("start: " + start + " end: " + end + " sum: " + sum);
            if (sum >= s) {
                min = Math.min(min, end - start);
            }


        }
        if(min == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);

    }
}
