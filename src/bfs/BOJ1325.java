package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1325 {
    static int[] answer;
    static List<List<Integer>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        answer = new int[n];
        adj = new ArrayList<>();
        for (int i = 0; i < n ; i++) { // cpu no는 012 -> 답에서 더하자
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj.get(from-1).add(to-1);
        }

        for (int i = 0; i < n; i++) {
            bfs(i);
        }

        int max = 0;
        for (int a : answer) {
            max = Math.max(max, a);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (answer[i] == max) {
                sb.append(i+1).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[answer.length];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);
        visited[start] = true;


        while (!q.isEmpty()) {
            int p = q.poll(); //자식 하나 꺼내서
            List<Integer> integers = adj.get(p);
            for (int i : integers) {
                if (visited[i]) continue;
                visited[i] = true;
                q.offer(i);
                answer[i]++;
            }
        }
    }
}
