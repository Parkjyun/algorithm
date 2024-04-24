package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        Queue<Long> q = new LinkedList<>();
        q.offer(a);
        int count = 0;
        long n = 0;
        outerloop:
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
//            System.out.println("---------count" + count);

            for (int i = 0; i < size; i++) {
                n = q.poll();
//                System.out.println(n);

                if (n == b) {
                    break outerloop;
                }

                if (n * 2 <= b ) q.offer(n*2);
                if (n*10 + 1 <= b) q.offer(n*10 + 1);
            }

        }
        if (n == b) System.out.println(count);
        else System.out.println(-1);
    }
}
