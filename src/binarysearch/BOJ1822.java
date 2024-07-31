package binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1822 {
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();

    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int an = Integer.parseInt(st.nextToken());
        int bn = Integer.parseInt(st.nextToken());
        int[] a = new int[an];
        int[] b = new int[bn];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < an; i++) {
            a[i] = (Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bn; i++) {

            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < bn; i++) {
            bs(a, b[i]);
        }
        if (a.length-count == 0) System.out.println(0);
        else {
            sb.append(a.length- count).append("\n");

            for (int n : a) {
                if (n!=0) sb.append(n).append(" ");
            }
            System.out.println(sb);
            //System.out.println(sb2);
        }


    }

    static int bs(int[] a, int find) {
        int l = 0;
        int h = a.length - 1;
        int m = (l+h)/2;

        while (l <= h) {
            if (a[m] == find) {
                count++;
                a[m] = 0;
                return find;
            } else if (a[m] < find) {
                l = m + 1;
                m = (l + h) / 2;
            } else {
                h = m - 1;
                m = (l + h) / 2;
            }
        }
        return 0;
    }
}

