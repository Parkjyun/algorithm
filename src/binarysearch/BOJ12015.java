package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ12015 {
    static int[] lis;
    public static void main(String[] args) throws IOException {
        //크면 lis 에 추가
        // 작거나 같으면 lb에 대치

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        lis = new int[n];
        Arrays.fill(lis, Integer.MAX_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > lis[index]) {
                lis[++index]=arr[i];
            } else {
                lis[lb(arr[i])] = arr[i];
            }
        }

        System.out.println(index+1);


    }

    static int lb(int obj) {
        int l = 0;
        int h = lis.length;
        int m;

        while (l < h) {
            m = l/2 + h/2;

            if (lis[m] >= obj) {
                h = m;
            } else {
                l =m+1;
            }
        }

        return l;
    }
}
