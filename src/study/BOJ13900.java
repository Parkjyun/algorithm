package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] sum = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < sum.length; i++) {//1: 1    2: 12   3: 123  4: 1234
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }
        long answer=0;
        for (int i = 1; i < sum.length-1; i++) {
            answer += sum[i]*(sum[i+1]-sum[i]);
        }
        System.out.println(answer);
    }
}
