package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ17835 {
    static long[] dist;
    static List<List<long[]>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시
        int m = Integer.parseInt(st.nextToken()); // 도로
        int k = Integer.parseInt(st.nextToken()); // 면접장
        dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);

        map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) { // to, cost
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map.get(p2).add(new long[]{p1, c});
        }
        List<Integer> start = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            start.add(Integer.parseInt(st.nextToken()));
        }
        dij(start);
        long answerD = Long.MIN_VALUE;
        long answerI = Long.MIN_VALUE;
        for (int i = 1; i < dist.length; i++) {
            if (answerD < dist[i]) {
                answerD = dist[i];
                answerI = i;
            }
        }
        System.out.println(answerI);
        System.out.println(answerD);

    }

    static void dij(List<Integer> start) {
        //obj, cost
        PriorityQueue<long[]> q = new PriorityQueue<>((a,b) -> (int)(a[1] - b[1]));
        for (int n : start) {
            q.offer(new long[] {n, 0});
            dist[n] = 0;
        }

        while (!q.isEmpty()) {
            long[] poll = q.poll();
            long cur = poll[0];
            long curD = poll[1];

            if (dist[(int)cur] != curD) {
                continue;
            }

            for (long[] next : map.get((int)cur)) {
                long nextD = curD + next[1];
                if (dist[(int) next[0]] > nextD) {
                    q.offer(new long[] {next[0], nextD});
                    dist[(int)next[0]] = nextD;
                }
            }
        }
    }
}
