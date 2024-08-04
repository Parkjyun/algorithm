package greedy;

import java.io.*;
import java.util.Arrays;

public class BOJ2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long max = 0;
        for (int i = 0; i < n; i++) {
            long temp = arr[i]*(n-i);
            max = Math.max(temp , max);
        }
        bw.append(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
