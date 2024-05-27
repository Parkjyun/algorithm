package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1309 {
    public static void main(String[] args) throws IOException {
        int[] dpo = new int[100001];
        int[] dpx = new int[100001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dpo[1] = 2;
        dpx[1] = 1;

        for (int i = 2; i <= n; i++) {
            dpo[i] = (dpo[i-1] + dpx[i-1]*2) % 9901;
            dpx[i] = (dpo[i-1] + dpx[i-1]) % 9901;
        }
        System.out.println((dpx[n] + dpo[n]) % 9901);
    }
}
