package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[n+1][n+1];

        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1) break;

            map[a][b] = true;
            map[b][a] = true;
        }
        Queue<Point> queue = new LinkedList<>();

        int[] scores = new int[n];
        for (int i = 1; i < n+1; i++) {
            int max = Integer.MIN_VALUE;

            boolean[] visited = new boolean[n+1];
            queue.offer(new Point(i, 0));
            visited[i] = true;
            while (!queue.isEmpty()) {
                Point p = queue.poll();
                max = Math.max(max, p.count);
                for (int j = 1; j < n+1; j++) {
                    if (map[p.number][j] && !visited[j]) {
                        visited[j] = true;
                        queue.offer(new Point(j, p.count+1));
                    }
                }
            }
            scores[i-1] = max;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < scores.length; i++) {
            min = Math.min(min, scores[i]);
        }

        int candidateCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < scores.length; i++) {
            if (min == scores[i]) {candidateCount++;
            sb.append(i+1 + " ");}
        }
        bw.append(String.valueOf(min)).append(" ").append(String.valueOf(candidateCount)).append("\n").append(sb);
        bw.flush();
        bw.close();


    }

    static class Point {
        int number;
        int count;
        private Point(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
}
