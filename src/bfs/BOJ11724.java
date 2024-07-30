package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {

            if (!visited[i+1]) {
                queue.offer(i+1);
                count++;
                visited[i+1] = true;
            }
            while (!queue.isEmpty()) {
                int p = queue.poll();
                for (int j = 1; j < n+1; j++) {
                    if (map[p][j] == 1 && !visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }


        }
        System.out.println(count);

    }
}
