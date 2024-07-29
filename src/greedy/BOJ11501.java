package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int[] arr = new int[m];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            long sum = 0;
            for (int a  = arr.length - 1; a >= 0; a--) {
                max = Math.max(arr[a], max);

                if (arr[a] < max)
                    sum += max - arr[a];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
