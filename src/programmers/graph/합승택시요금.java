package programmers.graph;

import java.util.*;

public class 합승택시요금  { // 530
    int[] dists;
    int[] dista;
    int[] distb;
    List<List<Point>> adj;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        dists = new int[n+1];//s시작 dis
        dista = new int[n+1];
        distb = new int[n+1];
        Arrays.fill(dists, Integer.MAX_VALUE/3);
        Arrays.fill(dista, Integer.MAX_VALUE/3);
        Arrays.fill(distb, Integer.MAX_VALUE/3);
        // fares[i]는 cdf -> 양 방향 c.d tkdl f, f는 십만 이하.

        // 시작점에서 모든 지점으로 다익
        // a,b에서 모든 지점으로 다익
        //1. math.min(a,b) or 시작 -> random +  random -> a + random -> b
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        adj.add(new ArrayList<>());// 0 - n

        for(int[] fare : fares) {
            int n1 = fare[0];
            int n2 = fare[1];
            int c = fare[2];
            adj.get(n1).add(new Point(n2, c));
            adj.get(n2).add(new Point(n1, c));
        }

        d(s, dists);
        d(a, dista);
        d(b, distb);
        int answer = Integer.MAX_VALUE/3;
        System.out.println(Arrays.toString(dists));

        for (int i = 1; i <= n; i++) { // i는 경유지
            answer = Math.min(answer, dists[i] + dista[i] + distb[i]); // s->i + i->a + i->b
        }
        return answer;
    }
    void d(int start, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[] {start, 0});
        dist[start] = 0;

        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            int s = p[0];
            int d = p[1];


            if (dist[s] < d) continue;

            List<Point> list = adj.get(s);
            for (int i = 0; i < list.size(); i++) {
                Point next = list.get(i);
                int nd = d + next.w;
                if (dist[next.p] > nd) {
                    pq.offer(new int[] {next.p, nd});
                    dist[next.p] = nd;
                }
            }
        }
    }

    class Point {// p는 다음점, w는 다음으로 가기 위한 점
        int p;
        int w;
        Point(int p, int w) {
            this.p = p;
            this.w = w;
        }
    }
}
