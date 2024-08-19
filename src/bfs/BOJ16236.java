package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236 { //다시풀기 + 정렬 조건 잘 보기
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static boolean[][] visited;
    static Point start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    start = new Point(i, j, 2, 0, 0);
                    map[i][j] = 0;

                }
            }
        }
        //검색 순서는 dx, dy로 인해 해결 되었다.
        //

        while (true) { // 각 라운드의 bfs결과가 false일때까지 -> false이면 break 한다.

            //bfs false인지 검사하고 false라면 각 라운드의 start 출력
            //새로운 round를 한다.
            PriorityQueue<Point> queue = new PriorityQueue<>((p1, p2) ->//거리가 같다면
                    p1.move != p2.move ? Integer.compare(p1.move, p2.move) : (p1.x != p2.x ? Integer.compare(p1.x, p2.x) : Integer.compare(p1.y, p2.y))
                    );
            visited = new boolean[n][n];
            queue.offer(start);
            visited[start.x][start.y] = true;
            boolean flag = false;
            outerloop : while (!queue.isEmpty()) {//라운드마다 bfs를 진행

                Point p = queue.poll();

                if (map[p.x][p.y] < p.size && 0 < map[p.x][p.y]) {
                    start = p;
                    flag = true;// 먹이를 찾았다.
                    map[p.x][p.y] = 0;

                    break outerloop;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    //범위를 벗어나거나 방문했
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || map[nx][ny] > p.size) continue;
                    if (map[nx][ny] == p.size || map[nx][ny] == 0) {//먹지않고 이동한다
                        queue.offer(new Point(nx, ny, p.size, p.eat, p.move+1));
                        visited[nx][ny] = true;

                    } else if (map[nx][ny] < p.size && 0 < map[nx][ny]) {//먹는다 다음 라운드 진행 // 먹은
                        queue.offer(new Point(nx, ny, p.size, p.eat+1, p.move+1));
                        visited[nx][ny] = true;
                        //map[nx][ny] = 0;
                        //break outerloop;//여기가 문제임 먹이 찾자마다 걍 나가 버림 -> bfs내의 한 묶음은 진행돼야 함
                    }
                }
            }
            if (!flag) break;

            //이번라운드에 먹지 못했다.== 끝.
        }
        bw.write(String.valueOf(start.move));
        bw.flush();
        bw.close();
    }

    static class Point {
        int x;
        int y;
        int size;
        int eat;
        int move;
        Point (int x, int y, int size, int eat, int move) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eat = eat;
            this.move = move;
            if (this.eat == this.size) {
                this.eat = 0;
                this.size++;
            }
        }
    }
}
