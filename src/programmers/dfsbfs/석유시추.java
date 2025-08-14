package programmers.dfsbfs;

import java.util.*;

public class 석유시추 {
    int dx[] = {0,1,0,-1};
    int dy[] = {1,0,-1,0};
    int answer = 0;
    Set<Integer> cols = new HashSet<>();
    int[] colsum;

    boolean[][] visited;
    List<P> list = new ArrayList<>();
    public int solution(int[][] land) { // 1이 석유

        // bfs로 구한다.
        //List<P> iteration돌면서 contains ++
        visited = new boolean[land.length][land[0].length];
        colsum = new int[land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (!visited[i][j] && land[i][j] == 1) {

                    bfs(i,j, land);// 하나의 석유 덩어리 발견
                }
            }
        }
        int max = 0;
        for (int s : colsum)max =  Math.max(max,s);

        return max;
    }

    void bfs(int i, int j, int[][] land) {
        Queue<int[]> q = new ArrayDeque<>();

        P petrol = new P(1);
        petrol.ys.add(j);

        q.offer(new int[] {i, j});
        cols.add(j);
        visited[i][j]= true;
        while(!q.isEmpty()) {
            int[] p = q.poll();

            for (int a = 0; a < 4; a++) {
                int nx = p[0] + dx[a];
                int ny = p[1] + dy[a];
                if (nx < 0 || ny < 0 || nx >= visited.length || ny >= visited[0].length || visited[nx][ny]) continue;
                if (land[nx][ny] == 1) {
                    petrol.s++;
                    petrol.ys.add(ny);

                    q.offer(new int[] {nx,ny});
                    cols.add(ny);
                    visited[nx][ny] = true;
                }
            }
        }
        for (int y : petrol.ys) {
            colsum[y] += petrol.s;
        }
    }

    class P {
        int s;
        Set<Integer> ys;

        P(int size) {
            s = size;
            ys = new HashSet<>();
        }
    }
}
