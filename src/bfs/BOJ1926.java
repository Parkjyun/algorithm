package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//3,2
public class BOJ1926 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int size = 0;
    static int max;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];


        for(int i = 1; i < map.length; i++) {
            for(int j = 1; j < map[i].length; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        bfs();
        System.out.println(count);
        System.out.println(max);
    }

    static void bfs() {
        max = 0;
        for(int i = 1; i < map.length; i++) {
            for(int j = 1; j < map[i].length; j++) {
                if(visited[i][j] == true || map[i][j] == 0) continue;//모든 map에 대하여 방문한 곳이거나 0이면 아무것도 하지 않음

                visited[i][j] = true;//방문하지 않은 곳이라면 방문으로 표시
                queue.offer(new Point(i, j));//큐에 넣음
//             왜 여기서 전체 그림의 수를 올리고 size를 초기화?
//             아래에서 현재 잡은 map을 기준으로 탐색을 할 것임 그리고 queue를 비우면서 검색할거야
//             그리고 다시 for문을 돌려서 visit안한 map을 찾아
//             근데 얘가 이번에 새로 잡였다는 것은 새로운 그림의 시작이라는 뜻
                count++;//전체 수를 하나 늘리고
                size = 0;

                while (!queue.isEmpty()) {
                    Point p = queue.poll();
                    size++;

                    for (int l = 0; l < 4; l++) {
                        int nx = p.x + dx[l];
                        int ny = p.y + dy[l];

                        if (1 > nx || nx > n || 1 > ny || ny > m) continue;
                        if (map[nx][ny] == 1 && visited[nx][ny] == false) {
                            visited[nx][ny] = true;
                            queue.offer(new Point(nx, ny));
                        }
                    }
                    if(size > max) max = size;
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