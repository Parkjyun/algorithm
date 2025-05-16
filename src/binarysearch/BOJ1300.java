package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1300 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());



        long l = 1;
        long h = 10000000000L;
        while (l < h) {
            long m = (l+h)/2;

            if (k <= lessOrEquals(m)) {
                h = m;
            } else {
                l = m+1;
            }
        }

        System.out.println(l);
    }

    static long lessOrEquals(long num) {
        long r = 0;
        for (int i = 0; i < n; i++) {
            r+= Math.min(num / (i+1), n);
        }
        return r;
    }
}
