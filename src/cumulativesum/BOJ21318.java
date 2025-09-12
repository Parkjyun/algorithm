package cumulativesum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21318 {
    public static void main(String[] args) throws IOException {
        //n개의 악보 1 -n
        // 각 악보는 난이도를 지닌다.
        // x-y를 악보 번호 순서대로 연주하는 것이 피아노 체조
        // 이번난이도 > 다음난이도 == 실수, 마지막은 실수 ㄴㄴ
        // 십만 *     십만에 대해 x,y가 주어질 때 실수 얼마나 할지?? ->
        //각각의 회수마다 for문을 돈다면
        // x,y가 주어질 때 실수하는 수를 nlogn이하로
        // 1 2 3 4 5 6 7  8 9
        // 1 2 3 3 4 1 10 8 1
        // 0 0 0 0 1 1 2  3 3 // 처음부터 index까지 살수
        // 46 -> 2-1 = 1

        //cs[y] - cs[x-1], if cs[y] > cs[y-1]   -1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] cs = new int[n+1];
        for (int i = 1; i < n; i++) {
            cs[i] = cs[i-1]; // 0- i번째숫자까지 실수
            if (arr[i-1] > arr[i]) {
                cs[i]++;
            }
         }
        cs[n] = cs[n-1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = cs[b] - cs[a-1];
            if (cs[b] > cs[b-1]) r--;
            sb.append(r).append("\n");
        }
        System.out.println(sb);
    }
}
