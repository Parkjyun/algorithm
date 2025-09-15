package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1238RE {
    static int[] dist;
    static int n;
    static List<List<int[]>> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //n개의 숫자로 구분된 마을
        // n명의 학생이 x번 마을에 모여서 파티
        // 마을에는 M개의 단방향 퍼타애 참석하고 다시 돌아가야함. 최단 거리. -> n명의 학생중 가장 많은 시간을 소비하는 학생운?

        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n  = Integer.parseInt(st.nextToken());//n개의 마을에 각각 한명의 학생
        int m  = Integer.parseInt(st.nextToken());
        int x  = Integer.parseInt(st.nextToken());



        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(s).add(new int[] {e, v});
        }


        // n명의 학생들 중 최소를 구해야한다.
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dij(i,x) + dij(x,i));
        }
        System.out.println(max);
    }

    static int dij(int start, int obj) {
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        dist[start] = 0;
        while(!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int curD = poll[1];
            if (dist[cur] != curD) continue; // 이번에 뽑은 게 최소값이 아니라면 pass

            for (int[] next : adj.get(cur)) {
                if (next[1] + curD < dist[next[0]]) { //
                    dist[next[0]] = next[1] + curD;
                    pq.offer(new int[] {next[0], next[1] + curD});
                }
            }
        }
        return dist[obj];
    }

}
