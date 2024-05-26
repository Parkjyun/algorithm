package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10816 {
    //n개의 숫자카드가 주어진다.
    //정수 m개가 주어짐 -> 각각에 대해 몇개의 숫자카드가 있는지 확인해야 함
    public static void main(String[] args) throws IOException {
        int n, m;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[] cards = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        int[] toFind = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0;i < m; i++) {
            toFind[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int l = lowerBound(cards ,toFind[i]);
            int u = upperBound(cards ,toFind[i]);
            int result = u-l;
            sb.append(result + " ");
        }
        System.out.println(sb);
    }

    static private int lowerBound(int[] arr , int n) {
        int l = 0;
        int h = arr.length;

        while (l < h) {
            int mid = (l + h) / 2;

            if (n <=arr[mid]) {
                h = mid;
            } else {
                l = mid+1;

            }
        }
        return l;
    }
    static private int upperBound(int[] arr , int n) {
        int l = 0;
        int h = arr.length;

        while (l < h) {
            int mid = (l + h)/2;
            if (n < arr[mid]) {
                h = mid;
            } else {
                l = mid+1;
            }
        }
        return h;

    }
}