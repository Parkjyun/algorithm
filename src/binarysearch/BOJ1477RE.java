package binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1477RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+2];
        arr[0] = 0;
        arr[n+1] = l;


        for (int i = 1; i < n+1;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] dif = new int[n+1];
        for(int i = 1; i < n+2; i++) {
            dif[i-1] = arr[i] - arr[i-1];
        }
        Arrays.sort(dif);//간거리를 구햇다
        int low = 1;
        int high = l-1;
        int mid = low + (high-1)/2;
        int answer = 0;
        while(low <= high) {
            mid = low + (high-low)/2;


            // 몇개의 휴계소를 세우는 것인지 계산
            // 도로의 양 끝에는 불가하고
            // 이미 휴게소가 있는 곳에는 세우면 안 된다,
            // mid는 휴게소가 없는 구간의 최댓값.
            int toBuild = 0;
            for(int d : dif) {//d는 각 구간의 길이
                toBuild += d / mid;
                if(d % mid == 0) {
                    toBuild -= 1;
                }
            }
            /// /////////////////////
            if (toBuild > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
                answer = mid;
            }
        }
        System.out.print(answer);
    }
}
