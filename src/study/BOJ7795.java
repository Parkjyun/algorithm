package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 {
    static int[] b;
    static int m;
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            b = new int[m];


            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(b);//오름차순정렬

            for (int j = 0; j < n; j++) {
                binarySearch(a[j]);
            }
            sb.append(answer + "\n");



        }

        System.out.println(sb);

    }

    private static void binarySearch(int target) {
        int start = 0;
        int end = m-1;
        int middle = 0;
        while (start <= end) {
            middle = (start + end) / 2;
            if (target > b[middle]) {
                start = middle+1;
            } else {
                end = middle - 1;
            }
        }
        answer +=start;
    }
}
