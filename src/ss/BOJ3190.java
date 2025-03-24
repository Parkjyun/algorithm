package ss;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3190 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Deque<Point> snake = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        //벽또는 자기 자신과 몸이 부딪히면 게임이 끝난다. -> 벽을 만나거나 자신을 만나면 끝
        // 벽만나는 것은 ㅇㅋ 자신을 만나는 것은?? q로 관리.
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        StringTokenizer st;
        //사과
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        int t = Integer.parseInt(br.readLine());
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int m = st.nextToken().equals("L")  ? 0 : 1; //0이 왼쪽 //1이 오른쪽 dx index -> 오른쪽이 + 1
            q.add(new int[] {s, m});
        }

        int s = 0;

        snake.offer(new Point(0,0));
        int di = 0;
        while (true) {
            s++;//0->1, 1->2, 2->3
            Point p = snake.peekLast();//가장 최근에 들어간놈 빼온다.

            int nx = p.x + dx[(di) % 4];
            int ny = p.y + dy[(di) % 4];

            //범위를 벗어나거나 본인을 만지면 out
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
            if (isTouching(nx, ny))
            {break;}


            //사과라면 하나 넣어준다 해준다. 아니라면 맨처음에 넣은 것 뺀다
            if (map[nx][ny] == 1) {//사과라묜
                map[nx][ny] = 0;
                snake.offer(new Point(nx, ny));//하나 넣는다.
            } else {
                snake.poll();//사과가 아니라면 가장 처음에 넣은 것 뺀다. == 꼬리
                snake.offer(new Point(nx, ny));
            }


            //1초끝나구 방향을 바꾼다.
            if (!q.isEmpty() && q.peek()[0] == s) {//만약 방향을 바꿀 타이임이라면
                int[] poll = q.poll();
                if (poll[1] == 1) {//오른쪽
                    di = (di + 1+4) % 4;
                } else {//왼쪽
                    di = (di - 1+4) % 4;
                }

            }
        }
        System.out.println(s);
    }

    static boolean isTouching(int x, int y) {
        for (Point p : snake) {
            if (p.x == x && p.y == y) {
                return true;
            }
        }
        return false;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y =y ;
        }
    }
}
