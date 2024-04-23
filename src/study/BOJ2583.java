package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2583 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        //위에서 x,y 바꿨기에 밑에도 x,y 바뀌어야 돼

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[x][y] = 1;//1은 방문할 수 없는 곳
                }
            }
        }
        //1인 부분은 가면 안 되는 곳이다.
        bfs();
        System.out.println(sb);
    }

    //지도에서 1은 방문할 수 없는 곳이다
    private static void bfs() {//나눠진 면적을 구하고 각각의 면적에 대한 크기를 구해야 한다.
        int count = 0;

        Queue<Point> queue = new LinkedList();//
        List<Integer> areas = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {//큐에 넣을 것이다

                if (!visited[i][j] && map[i][j] == 0) {//방문하지 않았고
                queue.offer(new Point(i,j));
                visited[i][j] = true;
                count++;
                int area = 1;
                    while (!queue.isEmpty()) {//큐가 비어있지 않다면 다음을 해라. 무엇을 ? 방문했다면
                        Point p = queue.poll();
                        for (int l = 0; l < 4; l++) {
                            int nx = p.x + dx[l];
                            int ny = p.y + dy[l];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 1) continue;//1. 범위 넘어가거나 2. 방문한 곳이거나 3. 방문할 수 없는 곳이면 continue
                            visited[nx][ny] = true;

                            area++;
                            queue.offer(new Point(nx,ny));
                        }

                    }
                    areas.add(area);
                }
            }
        }
        sb.append(count+ "\n");
        Collections.sort(areas);
        for (int a : areas) {
            sb.append(a + " ");
        }

    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

}
