package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286 {
    //우선순위큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //절댓값이 같다면 작은 것 우선순위, 절댓값이 다르다면, 절댓값 작은 것 부터 우선 순
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Math.abs(o1) == Math.abs(o2) ?
                Integer.compare(o1,o2) : Integer.compare(Math.abs(o1), Math.abs(o2)));
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a != 0) {
                pq.offer(a);
            } else {//0이라면
                if (pq.size() == 0) System.out.println(0);
                else System.out.println(pq.poll());

            }

        }

    }
}
