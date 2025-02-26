package programmers.graph;

import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
    static boolean[][] map;
    static boolean[] visited;
    static int curMaxDistance = 0;
    static int answer = 1;

    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    public static int solution(int n, int[][] edge) {

        boolean[][] map = new boolean[n+1][n+1];//1~6까지
        boolean[] visited = new boolean[n+1];

        for(int i = 0; i < edge.length; i++) {// 0 - 6

            map[edge[i][0]][edge[i][1]] = true;
            map[edge[i][1]][edge[i][0]] = true;
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(1, 0));
        visited[1] = true;

        int count = 1;
        while(!q.isEmpty()) {
            Point p = q.poll();
            if (p.distance == curMaxDistance) {
                answer++;
            }
            for(int j = 1; j < n+1; j++) {
                if(map[p.node][j] && !visited[j]) {
                    q.offer(new Point(j, p.distance + 1));
                    System.out.println(j + ", " + (p.distance + 1));
                    if(p.distance + 1 > curMaxDistance) {//신기록이 나왔다면
                        curMaxDistance = p.distance + 1;
                        answer = 0;
                    }
                    visited[j] = true;

                }
            }
        }
        return answer;
    }


    static class Point {
        int node;
        int distance;

        public Point(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

}
