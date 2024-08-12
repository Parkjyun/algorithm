package twopointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int s = 0;
        int e = 0;

        while(s < n) {
            if (e == n) break;
            if (arr[e] - arr[s] < m) {
                e++;

            } else if (arr[e] - arr[s] > m) {
                min = Math.min(min, arr[e] - arr[s++]);
            } else {
                System.out.println(m);
                return;
            }
        }
        System.out.println(min);
    }
}
