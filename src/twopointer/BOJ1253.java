package twopointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int count = 0;
        // -2 0 1 2 3 -> 각각에 대해 처음부터 끝까지 돌면서
        //목표합을 구하기 위해 lr을 합해서 같은지 몬다.
        // 합이 크다면 r--
        // 합이 작다면 ㅣ++
        //만약 i와 l 또는 r이 같나면 continue한다
        int good = 0;
        for (int i = 0; i < arr.length; i++) {

            int left = 0;
            int right = arr.length - 1;

            while(left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];

                if (sum > arr[i]) {
                    right--;
                } else if (sum < arr[i]) {
                    left++;
                } else {//good
                    good++;
                    break;
                }

            }

        }
        System.out.println(good);
    }
}
