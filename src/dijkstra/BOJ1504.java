package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504 {
    static List<List<Point>> list;
    static int[] dist;
    static int n;
    static final int MAX = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //node가 n개
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Point(end, weight));
            list.get(end).add(new Point(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int answer;
        d(1);
        int oneV1 = dist[v1];
        int oneV2 = dist[v2];
        d(v1);
        int v1v2 = dist[v2];
        d(n);
        int v1n = dist[v1];
        int v2n = dist[v2];
        //만약 경로가 없다면 maxval -> 음수가 된다. 만약 둘다 음수라면
        int r1 = oneV1 +  v1v2 + v2n;// 0 + v + 0
        int r2 = oneV2 +  v1v2 +  v1n;// 1-n + 1-n + 0

        if (r1 >= MAX && r2 >= MAX) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(r1,r2));
        }
    }

    static void d(int start) {
        dist = new int[n+1];
        Arrays.fill(dist, MAX);
        dist[start] = 0;

        //정렬 순서 = distance작은 순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int curP = poll[0];
            int curD = poll[1];

            //curP에서 연결된 모든 노드들을 탐색한다.
            for (int i = 0; i < list.get(curP).size(); i++) {
                Point p = list.get(curP).get(i);
                int newD = curD + p.distance;

                if (newD < dist[p.to]) {
                    dist[p.to] = newD;
                    pq.offer(new int[]{p.to, newD});
                }
            }
        }
    }

    static class Point {
        int to;
        int distance;

        Point(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
}
