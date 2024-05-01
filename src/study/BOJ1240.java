package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1240 {
    static int[][] map;
    static boolean[] visited;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[s][e] = d;
            map[e][s] = d;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bfs(s, e);
        }
        System.out.println(sb);

    }

    static void bfs(int s, int e) {
        visited = new boolean[n+1];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(s, 0));
        visited[s] = true;
        int sum=0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            sum = node.dist;;
            if (node.num == e) break;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && map[node.num][i] > 0) {
                    q.offer(new Node(i, node.dist + map[node.num][i]));
                    visited[i] = true;
                    sum+=map[node.num][i];
                }
            }
        }
        sb.append(sum+"\n");
    }

    static class Node {
        int num;
        int dist;
        private Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
}
