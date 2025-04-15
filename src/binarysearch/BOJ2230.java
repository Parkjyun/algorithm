package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int l = i;
            int h = arr.length;
            int mid=0;
            //lower bound
            while (l < h) {
                mid = l + (h-l)/2;
                if (arr[mid] >= arr[i] + m) {
                    h = mid;
                } else {
                    l = mid+1;
                }

            }

            if (h == n) { // h가 바뀌지 않았다는 것은 arr[i] + m 이상 값이 없다는 것 -> 그럼 continue해서 최소 차 갱신을 하지 않는다.
                continue;
            }

            answer = Math.min(answer, arr[l] - arr[i]);
            if (answer == m) {
                break;
            }
        }
        System.out.println(answer);
    }
}
