package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2109 {
    public static void main(String[] args) throws IOException {
        //어차피 하루에 한번밖에 못한다.
        //
        //pq에 넣어서
        // 1. 남은 날짜, 2. 가장 큰거.
        // 2. 가장 큰거를 뽑아서, 다음날까지 계속 뽑아.

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            //가격 오름차순
                return a[0] - b[0];
        });


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a,b) -> {
            //날짜 오름차순
            return a[1] - b[1];
        });

        for (int i = 0; i < n; i++) {
            int[] s = arr[i];
            int price = s[0];
            int day = s[1];

            pq.offer(new int[] {price, day});

            while (pq.size() > day) {
                pq.poll(); // 작은 것 나옴
            }


        }
        int sum = 0;
        for (int[] num : pq) {
            sum+=num[0];
        }


        System.out.println(sum);

    }
}
