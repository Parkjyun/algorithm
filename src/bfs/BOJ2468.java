package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer;
    static int max = Integer.MIN_VALUE;
    static int maxHeight = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }
        for (int k = 0; k <= maxHeight; k++) {//주어진 최대의 maxheight만큼만 실행시킴
            answer = 0;//매 level마다 안전 영역의 개수 초기화
            visited = new boolean[n][n];//visited여부도 초기화
            bfs(k);//bfs한번함
            if(max < answer)//각각의 level 이후 answer이 max보다 크다면
                max = answer;//max 갱신
        }
        System.out.println(max);
    }

    public static void bfs(int l) {//각각의 level에 대해서 bfs를 한번 실행함
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {//모든 포인ㅌ에 대해서
                if(visited[i][j] || map[i][j] <= l) continue;//방문한 곳이거나 높이가 작다면 무시
                queue.offer(new Point(i,j));
                visited[i][j] = true;
                answer++;
                while(!queue.isEmpty()) {
                    Point p = queue.poll();
                    for (int k = 0; k < 4; k++) {//하나의 포인트에 대해서
                        int x = p.x + dx[k];
                        int y = p.y + dy[k];
                        //1. 범위 나가고 2. level보다 작거나 같으면, 이미 방문한 곳이면 pass
                        if (x < 0 || y < 0 || x >= n || y >= n || map[x][y] <= l || visited[x][y]) continue;
                        visited[x][y] = true;
                        queue.offer(new Point(x,y));
                    }
                }
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
