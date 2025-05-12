package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9019 {
    static int to;
    static String answer;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];
            bfs(start);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static class Point {
        int n;
        String s;

        public Point(int n, String s) {
            this.n = n;
            this.s = s;
        }
    }

    static void bfs(int start) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(start, ""));
        visited[start] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.n == to) {
                answer = p.s;
                break;
            }
            int nv = d(p.n);
            if (!visited[nv]) {
                visited[nv] = true;
                q.offer(new Point(nv, p.s + "D"));
            }

            nv = s(p.n);
            if (!visited[nv]) {
                visited[nv] = true;
                q.offer(new Point(nv, p.s + "S"));
            }

            nv = l(p.n);
            if (!visited[nv]) {
                visited[nv] = true;
                q.offer(new Point(nv, p.s + "L"));
            }

            nv = r(p.n);
            if (!visited[nv]) {
                visited[nv] = true;
                q.offer(new Point(nv, p.s + "R"));
            }
        }
    }

    static int d(int n) {
        return (2*n) % 10000;
    }
    static int s(int n) {
        if (n == 0) {
            return 9999;
        }
        return n - 1;
    }
    static int l(int n) {
        return (n%1000 * 10) + (n/1000);
    }

    static int r(int n) {
        return (n%10*1000) + (n/10);
    }
}
