package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] counts = new int[100001];

        int l = 0;
        int h = 0;
        int answer = Integer.MIN_VALUE;

        while (h <= n-1) {//마지막 인덱스까지 loop문돈다.
            while (h <= n-1 && counts[arr[h]] < max) {
                counts[arr[h]]++;
                h++;
            }
            answer = Math.max(answer, h-l);
            counts[arr[l]]--;
            l++;
        }
        System.out.println(answer);
    }
}
