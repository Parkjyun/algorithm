package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ17140 {
    static int rmax, cmax;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        int[][] map = new int[101][101];
        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rmax = 3;
        cmax = 3;
        for (int i = 0; i <= 100; i++) {

            //매초마다
            if (map[r][c] == k) {
                System.out.println(i);
                return;
            }

            //100초 동안 움직임
            if (rmax >= cmax) { // row 연산
                cmax = 0;
                for (int j = 1; j < 100; j++) {
                    row(map[j]);
                }

            } else { // column 연산
                rmax = 0;
                for (int j = 1; j < 100; j++) { // 하나의 컬럼에 대해서
                    col(map, j);
                }
            }
        }
        System.out.println(-1);
    }

    static void col(int[][] map, int col) {
        Map<Integer, Integer> saved = new HashMap<>();
        for (int i = 1; i < map.length; i++) {
            saved.put(map[i][col], saved.getOrDefault(map[i][col], 0) + 1);
        }
        PriorityQueue<Num> pq = new PriorityQueue<>((a,b) -> {
            if (a.count == b.count) {
                return a.num-b.num;
            } else {
                return a.count - b.count;
            }
        });

        for (Map.Entry<Integer, Integer> e : saved.entrySet()) {
            pq.offer(new Num(e.getKey(), e.getValue()));
        }
        int i = 1;
        for (int j = 1; j < map.length; j++) {
            map[j][col] = 0;
        }
        while (!pq.isEmpty()) {
            Num poll = pq.poll();
            if (poll.num == 0) continue;
            map[i++][col] = poll.num;
            map[i++][col] = poll.count;
            if (i > 100) break;
        }
        rmax = Math.max(rmax, i);
    }

    static void row(int[] map) {
        Map<Integer, Integer> saved = new HashMap<>();

        for (int i = 1; i < map.length; i++) {
            saved.put(map[i], saved.getOrDefault(map[i], 0) + 1);
        }
        PriorityQueue<Num> pq = new PriorityQueue<>((a,b) -> {
            if (a.count == b.count) {
                return a.num-b.num;
            } else {
                return a.count - b.count;
            }
        });

        for (Map.Entry<Integer, Integer> e : saved.entrySet()) {
            pq.offer(new Num(e.getKey(), e.getValue()));
        }
        int i = 1;

        Arrays.fill(map, 0);
        while (!pq.isEmpty()) {
            Num poll = pq.poll();
            if (poll.num == 0) continue;

            map[i++] = poll.num;
            map[i++] = poll.count;
            if (i > 100) break;
        }
        cmax = Math.max(cmax, i);
    }

    static class Num{
        int num;
        int count;

        Num(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
