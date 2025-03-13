package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {
    static List<List<Point>> list;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }

        // 0이면 길이 없는 것 1이상이면 길이 있고 weigh라는 의미

        distance = new int[n+1];
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Point(end, weight));
        }


        d(s);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == 0) {
                sb.append(0).append("\n");
            } else if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }

        System.out.println(sb);



    }

    static void d(int s) {
        //pq는 오름차순이어야 가장 작은 것부터 나온다. distance 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {return a[1] - b[1];});

        pq.offer(new int[] {s, 0});
        //시작점은 -1
        //0은 갈 수 없는 곳들 (최초 힙 메모리 초기화 이후 건들지 ㅣㅇ낳아)
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s] = 0;


        while (!pq.isEmpty()) {
            int[] poll = pq.poll(); // 현재 가장 작은 것 나옴
            int point = poll[0];
            int curD = poll[1];

            if (curD != distance[point]) continue;

            for (int i = 0; i < list.get(point).size(); i++) { // 현재 위치에서 가능한 후보들 전부 돌면서
                if (list.get(point).get(i).distance > 0) {//만약에 길이 있다면
                    if (distance[list.get(point).get(i).to] > curD + list.get(point).get(i).distance) {
                        distance[list.get(point).get(i).to] = curD + list.get(point).get(i).distance;//distance도 해담
                        pq.offer(new int[] {list.get(point).get(i).to, curD + list.get(point).get(i).distance}); //넣어준다.
                    }

                }
            }
        }
    }
    static class Point {
        int to;
        int distance;

        public Point(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
}
