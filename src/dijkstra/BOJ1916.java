package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1916 {
    static List<List<Point>> list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());//도시
        int m = Integer.parseInt(br.readLine());// 간선의 수

        dist = new int[n+1];
        list = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {//첫 list의 index는 from이다.
            list.add(new ArrayList<>());
        }
        //s t w
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(s).add(new Point(t,w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        Arrays.fill(dist, Integer.MAX_VALUE);
        d(start);

        System.out.println(dist[end]);
    }

    static void d(int start) {
        // 0 은 curpoint, 1은 dist
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {return a[1] - b[1];});
        q.offer(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int curP = poll[0];//시작점
            int curD = poll[1];

            if (dist[curP] < curD) continue;

            for (int i = 0; i < list.get(curP).size(); i++) {
                int newD = list.get(curP).get(i).weight + curD;
                int to = list.get(curP).get(i).to;
                if (newD < dist[to]) {//갱신할만한 가치작 ㅣㅇㅆ다면
                    dist[to] = newD;
                    q.offer(new int[]{to, newD});

                }

            }
        }


    }

    static class Point {
        int to;
        int weight;
        public Point(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
