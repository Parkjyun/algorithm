package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static int startNumber;
    static boolean[][] arr;
    static StringTokenizer st;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());// 정점의 수
        m = Integer.parseInt(st.nextToken());// 간선의 수
        startNumber = Integer.parseInt(st.nextToken());
        arr = new boolean[n+1][n+1];//arr은 정점간의 간선을 나타내기 위한 배열, 양방향 1차원 == start, 2차원 = end
        check = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            arr[first][second] = true;
            arr[second][first] = true;
        }
        dfs(startNumber);
        sb.append("\n");
        bfs();
        System.out.println(sb);
    }

    private static void dfs(int start) {
        check[start] = true;
        sb.append(start + " ");

        for (int i = 1; i <= n; i++) {
            if (arr[start][i] && !check[i])
                dfs(i);
        }
    }
    private static void bfs() {
        for (int i = 0; i < check.length; i++) {
            check[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNumber);
        check[startNumber] = true;
        while (!queue.isEmpty()) {
            int toCheck = queue.poll();//첫번째 검사 빼고
            sb.append(toCheck + " ");//적고

            for (int i = 1; i <= n; i++) {//나빼고 나머지 n-1에 대해 갈 곳이 있나 확인한다,
                if (arr[toCheck][i] && !check[i]) {//간선이 있고 방문하지 않았다면 다음에 방문하도록 큐에 넣는다.
                    queue.offer(i);
                    check[i] = true;
                }
            }
        }
    }
}
