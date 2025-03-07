package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1238 {

    static int[][] map;
    static int[] distance;
    static int n;

    public static void main(String[] args) throws IOException {
        //n개의 마을, 각각에 학생
        // m개의 도로
        // 도로는 단방향 + n명의 학생들 중 오고 가는데 갖아 많은 시간을 소비하는 학생은 누구?
        // n, m, x가 주어진다. x가 목적지
        // 도로 시작점, 끝점, 소요시간이 주어진다.
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];


        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int totalDistance = dij(i, x) + dij(x, i);

            answer = Math.max(totalDistance, answer);
        }
        System.out.println(answer);
    }

    static int dij(int start, int obj) {
        PriorityQueue<Point> q = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Point point = new Point(start, 0);
        q.offer(point);
        distance[start] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();//현재 위치
            if (p.index == obj) {
                break;
            }
            for (int i = 1; i <= n; i++) {//현재 위치에서 갈 수 있는 모든 마을 중에
                if (map[p.index][i] > 0) {//길이 있다면
                    int nextDistance = p.distance + map[p.index][i];
                    if (distance[i] > nextDistance) {
                        distance[i] = nextDistance;
                        q.offer(new Point(i, nextDistance));
                    }
                }
            }
        }

        return distance[obj];


    }

    static class Point {
        int index;
        int distance;

        public Point(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
