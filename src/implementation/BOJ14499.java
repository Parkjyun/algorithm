package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499 {
    static int[] dice = new int[6];
    static int[][] map;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int curx = x;
        int cury = y;
        while (st.hasMoreTokens()) {
            int d = Integer.parseInt(st.nextToken());

            if (curx + dx[d-1] < 0 || cury + dy[d-1] < 0 || curx + dx[d-1] >= n || cury + dy[d-1] >= m) continue;
            curx += dx[d-1];
            cury += dy[d-1];
            sb.append(move(d, curx, cury)).append("\n");

        }
        System.out.println(sb);
    }

    static int move(int d, int dx, int dy) { //윗면 출력
        if (d == 4) {
            int temp = dice[3];

            //바닥
            dice[3] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[0];
            dice[0] = temp;
        }
        if (d == 3) {
            int temp = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[3];
            dice[3] = temp;
        }
        if (d == 1) {
            int temp1 = dice[0];
            int temp2 = dice[2];
            dice[0] = dice[5];
            dice[2] = dice[4];
            dice[4] = temp1;
            dice[5] = temp2;
        }
        if (d == 2) {
            int temp1 = dice[2];
            int temp2 = dice[0];
            dice[0] = dice[4];
            dice[2] = dice[5];
            dice[4] = temp1;
            dice[5] = temp2;

        }
        if (map[dx][dy] == 0) {
            map[dx][dy] = dice[0];
        } else {
            dice[0] = map[dx][dy];
            map[dx][dy] = 0;
        }
        return dice[2];
    }
}
