package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int s = 0;
        int e = 0;
        int min = Integer.MAX_VALUE;
        while (s < n) { // s = 끝 index가 최대
            if (e == n) break;
            if (arr[e] - arr[s] < m) e++;
            else { // 차가 큰 경우
                min = Math.min(min, arr[e] - arr[s]);
                s++;
            }
        }
        System.out.println(min);
    }
}
