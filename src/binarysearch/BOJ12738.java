package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ12738 {
    static int[] arr;
    static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        lis = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        lis[0] = arr[0];
        int index = 0; // lis용
        for (int i = 1; i < arr.length; i++) {
            if(lis[index] < arr[i]) {
                lis[++index] = arr[i];
            } else {
                lis[lb(arr[i], index+1)] = arr[i];
            }
        }
        System.out.println(index+1);
    }

    static int lb(int obj, int end) {
        int l = 0;
        int h = end;
        int m = 0;
        while (l < h) {
            m = l/2 + h/2;

            if (lis[m] >= obj) {
                h = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
}
