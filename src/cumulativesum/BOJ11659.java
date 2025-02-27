package cumulativesum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String low = st.nextToken();
            String high = st.nextToken();
            sb.append(sum[Integer.parseInt(high)] - sum[Integer.parseInt(low) - 1] + "\n");
        }
        System.out.println(sb);

    }
}
