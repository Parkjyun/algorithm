package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ23757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        PriorityQueue<Integer> qPresent = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<Integer> qChild = new LinkedList<>();


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            qPresent.offer(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            qChild.offer(Integer.parseInt(st.nextToken()));
        }
        int answer = 1;
        while (!qChild.isEmpty()) { // 아이의 수만큼 check
            int child = qChild.poll();
            int present = qPresent.poll();
            if (present < child) {
                answer = 0;
                break;
            } else if (present == child) {
                continue;
            } else {
                qPresent.offer(present - child);
            }

        }
        System.out.println(answer);
    }
}
