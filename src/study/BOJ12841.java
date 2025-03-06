package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ12841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] cross = new int[n+1];
        int[] left = new int[n];
        int[] right = new int[n];
        long rsum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) { // 1234
            cross[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < left.length; i++) {//123
            left[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < right.length; i++) {//123
            right[i] = Integer.parseInt(st.nextToken());
            rsum += right[i];
        }

        long[] psum = new long[n+1];
        long[] ssum = new long[n+1];
        ssum[1] = rsum;
        psum[1] = 0;

        for(int i = 2; i < psum.length; i++) {
            psum[i] = psum[i-1] + (long)left[i-1];
            ssum[i] = ssum[i-1] - (long)right[i-1];
        }

        int answeri = 0;
        long answerl = 0;

        long min = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            long temp = psum[i] + ssum[i] + cross[i];
            if(temp < min) {
                min = temp;
                answeri = i;
                answerl = temp;
            }
        }

        System.out.println(answeri + " " + answerl);
    }
}
