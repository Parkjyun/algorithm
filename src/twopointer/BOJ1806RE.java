package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i+1] = sum[i] + arr[i];
        }

        int start  = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        while(true) {
            if (sum[end] - sum[start] >= s) {
                start++;
            } else {
                end++;
            }
            if (end == n+1 || start == n+1) break;
            if (sum[end] - sum[start] >= s) {
                min = Math.min(min, end - start);
            }

        }
        if(min == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);
    }
}
