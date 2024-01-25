package bfs;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int num = 0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n;
    static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        String temp;
        for(int i = 0; i < n; i++) {
            temp = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp.substring(j, j+1));
            }
        }
        bfs();
        System.out.println(num);
        Collections.sort(list);
        for(int l = 0; l < list.size(); l++)
            System.out.println(list.get(l));
    }
    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 0 || visited[i][j]) continue;
                //1이고 방문하지 않았다면.
                queue.offer(new Point(i,j));
                num++;
                visited[i][j] = true;
                count = 1;

                while (!queue.isEmpty()) {
                    Point point = queue.poll();
                    for (int p = 0; p < 4; p++) {
                        int x = point.x + dx[p];
                        int y = point.y + dy[p];
                        if(x < 0 || y < 0 || x >= n || y >= n || visited[x][y] || map[x][y] == 0) continue;
                        queue.offer(new Point(x,y));
                        visited[x][y] = true;
                        count++;

                    }
                }
                list.add(count);

            }
        }
    }
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
