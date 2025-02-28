package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    boolean[][] visited;
    int answer = 0;
    int n;
    int m;
    public int solution(int[][] maps) {
        //최단 기간이 걸리는 거리를 구하던가 안되면 -1을 반환해라.
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        bfs(maps);
        return answer;
    }

    public void bfs(int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 1));
        visited[0][0] = true;
        answer = -1;

        while(!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == n-1 && p.y == m-1) {
                answer =  p.count;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] == 1 ){
                    q.offer(new Point(nx, ny, p.count+1));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
