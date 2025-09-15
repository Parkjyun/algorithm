package programmers.graph;

import java.util.*;

public class 등산코스정하기 {
    List<List<int[]>> map = new ArrayList<>();
    int in[];
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        //intensity가 최소가 되는 등산 코스에 포함된 산봉우리 번호, intensity의 최솟값을 찰

        //산의 정점 수 = 50,000
        // 경로 수는 200,000
        //
        //1. 출발점과 산봉우리는 단방향으로 설정한다
        //2. 다익스트라의 dist대신 intensity -> 기존은 dist[from] + weight -> max(dist[from], weight)으로
        //3. intensity최소 ->for문내에서 i

        for (int i = 0; i <=n; i++) {
            map.add(new ArrayList<>());
        }
        Set<Integer> gateS = new HashSet<>();
        for (int g : gates) {
            gateS.add(g);
        }
        Set<Integer> summitS = new HashSet<>();
        for (int s : summits) {
            summitS.add(s);
        }

        for (int i = 0; i < paths.length; i++) {
            int a = paths[i][0];
            int b = paths[i][1];
            int w = paths[i][2];
            if (gateS.contains(a) || summitS.contains(b)) {
                map.get(a).add(new int[] {b, w});
            } else if (gateS.contains(b) || summitS.contains(a)) {
                map.get(b).add(new int[] {a, w});
            } else {
                map.get(a).add(new int[] {b, w});
                map.get(b).add(new int[] {a, w});
            }
        }
        in = new int[n+1];
        int snum = 0;
        int min = Integer.MAX_VALUE;

        dij(gates);
        Arrays.sort(summits);
        for (int i = summits.length-1; i >= 0; i--) {//intensity가장 작게하는 하는 산봉우리, 이떄의 최소값 -> 겹친다면 산봉우리 가장 작은 것 부터
            if (in[summits[i]] <= min) {
                min = in[summits[i]];
                snum = summits[i];
            }
        }
        return new int[] {snum, in[snum]};

    }
    void dij(int[] gates) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);//intensity순
        Arrays.fill(in, Integer.MAX_VALUE);
        for (int g : gates) {
            pq.offer(new int[] {g, 0});
            in[g] = 0;
        }

        while(!pq.isEmpty()) {

            int[] poll = pq.poll();
            int cur = poll[0];
            int curIn = poll[1];

            //이번에 뽑은 지점의 intensity가 최신화된 것이 아니라면
            if (in[cur] != curIn) continue;

            //in배열 최소로 유지
            for (int[] next : map.get(cur)) {
                int to = next[0];
                int weight = next[1];

                //다음 intensity보다 이전 intensity가 작다면
                if (in[to] > Math.max(weight, in[cur])) {
                    in[to] = Math.max(weight, in[cur]);
                    pq.offer(new int[]{to, Math.max(weight, in[cur])});
                }
            }
        }
    }
}
