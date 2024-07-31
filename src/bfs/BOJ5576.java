package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            map[b][a] = true;
        }

        Queue<Friend> queue = new LinkedList<>();
        queue.offer(new Friend(1,0));
        visited[1] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            Friend p = queue.poll();
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i] && map[p.n][i] && p.count < 2) {//방문하지 않았고 친구라면
                    queue.offer(new Friend(i, p.count+1));
                    count++;
                    visited[i] = true; // 친구의 친구라면
                }
            }
        }
        System.out.println(count);
    }
    static class Friend {
        int n;
        int count;

        private Friend(int n, int count) {
            this.n = n;
            this.count = count;
        }
    }
}
