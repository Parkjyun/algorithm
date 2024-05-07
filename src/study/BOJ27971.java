package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ27971 {
    static int n, m;
    static boolean[] visited;
    static int[][] range;
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());//키우기를 원하는 강아지의 수
        m = Integer.parseInt(st.nextToken());//범위의 수
        num = new int[2];
        num[0] = Integer.parseInt(st.nextToken());//a개의 강아지 생성
        num[1] = Integer.parseInt(st.nextToken());//b개의 강아지 생성
        range = new int[m][2];
        visited = new boolean[n+1];//index와 숫자는 동일// 0 - n
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            for (int p = l; p <= r; p++) {
                visited[p] = true;
            }
        }
        System.out.println(bfs());
    }
    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        visited[0] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.num == n) {
                return node.count;
            }

            for (int i = 0; i < 2; i++) {
                    int newn = node.num + num[i];
                    if (newn > n) continue;
                    if ( visited[newn]) continue;
                    visited[newn] = true;
                    q.offer(new Node(newn, node.count+1));
                }
            }
        return -1;

    }
    static class Node{
        int num;
        int count;
        Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
