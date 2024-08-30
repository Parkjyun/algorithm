package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int obj = Integer.parseInt(br.readLine());
        int answer = 0;
        Arrays.sort(arr);

        int s = 0;
        int e = arr.length-1;
        while (s < e) {
            if (arr[s] + arr[e] == obj) {
                answer++;
                s++;
                e--;
            }
            else if (arr[s] + arr[e] > obj) {
                e--;
            } else s++;
        }
        System.out.println(answer);
    }
}