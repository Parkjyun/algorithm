package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int pn = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int find1 = Integer.parseInt(st.nextToken());
        int find2 = Integer.parseInt(st.nextToken());

        int rn = Integer.parseInt(br.readLine());
        int[] visited = new int[pn+1];

        int[][] map = new int[pn+1][pn+1];

        for (int i = 0; i < rn; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(find1);
        visited[find1] = 1;
        while(!queue.isEmpty()) {
            int p = queue.poll();

            for (int i = 1; i < pn+1; i++) {
                if (map[p][i] == 0 || visited[i] != 0) continue;//관계가 없거나 방문한 사람이라면 pass
                visited[i] = visited[p]+1;
                queue.offer(i);
            }
        }
        String answer = visited[find2] == 0 ? String.valueOf(-1) : String.valueOf(visited[find2]-1);
        bw.write(answer);
        bw.flush();
        bw.close();

    }
}
