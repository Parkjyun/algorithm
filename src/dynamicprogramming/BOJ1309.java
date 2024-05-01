package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dpy = new long[n+1];
        long[] dpn = new long[n+1];

        dpy[1] = 2;
        dpn[1] = 1;

        for (int i = 2; i < n+1; i++) {
            dpy[i] = (dpy[i-1]%9901 + dpn[i-1]%9901*2)%9901;
            dpn[i] = (dpy[i-1]%9901 + dpn[i-1]%9901)%9901;
        }

        System.out.println(((dpy[n] + dpn[n])%9901));
    }
}
