package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용돈관리 {
    static int answer = 0;
    static int min, max, m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        min = 1;
        max = 100000*10000;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, arr[i]);

        }


        System.out.println(parametricsearch());
    }
    static int count(int money) {
        int answer = 0;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < arr[i]){
                cur = money;
                answer++;
            }

            cur -= arr[i];
        }
        return answer;
    }
    static int parametricsearch() {
        int l = min;
        int h = max;
        int mid = 0;
        while (l < h) {
            mid = (l + h)/2;

            if (count(mid) <= m) {
                h = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

}
