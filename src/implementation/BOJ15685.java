package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ15685 {
    static boolean map[][] = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            Deque<Integer> deque = new ArrayDeque<>();
            map[x][y] = true;
            deque.push(d);

            for (int j = 0; j < g; j++) {
                Deque<Integer> newS = new ArrayDeque<>(deque);
                while (!newS.isEmpty()) {
                    deque.push((newS.pop() + 1)%4);
                }
            }
            //stack에 방향.
            while (!deque.isEmpty()) {
                Integer poll = deque.pollLast();
                if (poll == 0) {
                    y+=1;
                    map[x][y] = true;
                } else if (poll == 1) {
                    x-=1;
                    map[x][y] = true;
                } else if (poll == 2) {
                    y-=1;
                    map[x][y] = true;
                } else if (poll == 3) {
                    x+=1;
                    map[x][y] = true;
                }
            }
        }
        System.out.println(check());
    }
    static void draw() {

    }

    static int check() {
        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) answer++;
            }
        }
        return answer;
    }
}
