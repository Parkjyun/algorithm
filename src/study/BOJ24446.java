package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ24446 {
    private static List<Integer>[] map;
    static boolean[] visited;
    static int n,m,s;
    static StringBuilder sb = new StringBuilder();
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         s = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[str].add(end);
            map[end].add(str);
        }
        bfs();

    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        result = new int[n+1];
        int depth = 0;
        for (int i = 0; i < result.length; i++)
            result[i] = -1;

        q.offer(s);
        result[s] = 0;
        visited[s] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int a = 0; a < size; a++) {
                int node = q.poll();
                result[node] = depth;
                for (int i : map[node]) {//기준점과 연결되어 있는애들
                    if (!visited[i]) {//방문하지 않았고 연결되어 있다면
                        q.offer(i);
                        visited[i] = true;
                    }
                }
            }
            depth++;

        }
        for (int i = 1; i <=n; i++) {
            sb.append(result[i] + "\n");
        }
        System.out.println(sb);
    }

}
