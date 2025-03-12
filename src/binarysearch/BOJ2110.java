package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int l = 1;
        int h = arr[n-1] - arr[0];
        int m;
        int a = 0;
        while (l <= h) {

            m = l + (h-l)/2;

            int calculated = calculated(arr, m);

            if (calculated < c) {
                h = m - 1;
            } else {
                a = m;
                l = m + 1;
            }

        }
        System.out.println(a);

    }
    static int calculated(int[] arr, int mid) {//mid가장 인근 값 -> return : 몇개를 설치할 ㅅ 있는가?
        int answer = 1;
        //arr이 주어질때 mid, mid+1, mid+2...등으로 총 몇개의 공유기를 설치할 수 있는가??
        int before = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - before >= mid) {
                answer++;
                before = arr[i];
            }
        }
        return answer;
    }
}
