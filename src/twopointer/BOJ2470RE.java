package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470RE {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int result1 = 0;
        int result2 = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int l = 0;
        int r = n - 1;
        int sum;
        int min = Integer.MAX_VALUE;
        while (l < r) {//두개가 달라야 하니
            sum = arr[l] + arr[r];
             if (sum == 0){ //합이 0이면 끝
                result1 = arr[l];
                result2 = arr[r];
                break;
            }
             if (min > Math.abs(sum)) {//최소다 //갱신한다.
                 result1 = arr[l];
                 result2 = arr[r];
                 min = Math.abs(sum);
             }


            if (sum > 0) {
                r--;
            } else if (sum < 0) {
                l++;
            }



        }
        System.out.println(result1 + " " + result2);
    }
}
