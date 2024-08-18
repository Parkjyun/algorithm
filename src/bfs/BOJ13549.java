package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13549 {
    static int[] dx = {1, -1};//순간이동은 0초
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = Integer.MAX_VALUE;
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(n,0));
        visited[n] = 0;
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == k) {
                min = Math.min(min, p.count);

            }
            int ns = 2* p.x;
            while (ns <= 100000 && p.count < visited[ns]){//방문하지 않았고 범위 이내라면 순간이동한다.

                queue.offer(new Point(ns, p.count));
                visited[ns] = p.count;
                ns *= 2;
            }
            for (int i = 0; i < 2; i++) {
                int nx = p.x + dx[i];
                if (nx > 100000 || nx < 0 || visited[nx] <= p.count + 1) continue;
                queue.offer(new Point(nx, p.count+1));
                visited[nx] = p.count+1;
            }
        }
        System.out.println(min);
    }

    static class Point {
        int x;
        int count;

        Point(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}
