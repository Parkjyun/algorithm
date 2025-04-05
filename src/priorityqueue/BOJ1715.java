package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class BOJ1715 {
    public static void main(String[] args) throws IOException {
        //10 20 40
        // 10 + 20 + 30 + 40
        // 12 45
        // 3
        // 7
        // 12
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue <Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int result = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int sum = a + b;
            result += sum;
            pq.offer(sum);
        }
        System.out.println(result);

    }
}
