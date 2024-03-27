package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2573 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] map;
    static int[][] meltCount;
    static int n;
    static int m;
    static int part;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int second = 0;
        part = 0;
        do {//와일문 한번이 녹이기 1회임
            int [][] meltCount = new int[n][m];//지우는 수를 보관하기 위한 공간
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) continue;//바다라면 지나감
                    for (int k = 0; k < 4; k++) { // 빙산에 대해 다음 행동을 4번 돌린다
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (map[nx][ny] == 0 ) meltCount[i][j]++;
                    }
                }
            }
            //위에서 빼야 되는 meltcount 배열 생성
            for (int i = 0; i < n; i++) {// 여기서 실제로 뺌
                for (int j = 0; j < m; j++) {
                    map[i][j] -= meltCount[i][j];
                    if (map[i][j] < 0) map[i][j] = 0;
                }
            }

            // 녹이기 완료

            //2개로 나뉘었는지 검사
            part = bfsfindpart();
            second++;
            if (check(map)) break;
        } while (part < 2);

        if (check(map) && part < 2) System.out.println(0);
        else System.out.println(second);
    }

    static int bfsfindpart() {
        Queue<Point> queue = new LinkedList<>();
        part = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 || visited[i][j]) continue; // 물이거나 방문한 곳이라면 지나간다.
                queue.offer(new Point(i, j));
                visited[i][j] = true;
                part++;
                while (!queue.isEmpty()) {
                    Point p = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = p.x + dx[k];
                        int ny = p.y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 0) continue;
                        queue.offer(new Point(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return part;
    }

    static boolean check(int[][] map) {//true -> all melt, false -> ice left
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m;j++) {
                if (map[i][j] != 0) return false;
            }
        }
        return true;
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
