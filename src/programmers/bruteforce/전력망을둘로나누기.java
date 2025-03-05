package programmers.bruteforce;

import java.util.*;

public class 전력망을둘로나누기 {
    boolean[][] map;
    boolean[] visited;
    public int solution(int n, int[][] wires) {

        map = new boolean[n+1][n+1];

        for (int[] wire : wires) {
            map[wire[0]][wire[1]] = true;
            map[wire[1]][wire[0]] = true;
        }
        int min = Integer.MAX_VALUE;
        for(int[] wire : wires) {//모든 와이어에 대해서
            visited = new boolean[n+1];
            int a = wire[0];
            int b = wire[1];
            //끊어.
            map[a][b] = false;
            map[b][a] = false;
            // 끊은 곳 기준으로 찾아.
            int part1 = bfs(a);
            int part2 = bfs(b);
            //원복시켜.
            map[a][b] = true;
            map[b][a] = true;

            min = Math.min(Math.abs(part1 - part2), min);
        }
        return min;
    }

    int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int count = 1;
        while(!q.isEmpty()) {
            int node = q.poll();
            for (int i = 1; i < map.length; i++) {
                if (!visited[i] && map[node][i]) { //방문하지 않았고 연결되어 있다면
                    q.offer(i);
                    visited[i] = true;
                    count++;
                }

            }

        }
        return count;
    }
}
