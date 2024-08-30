package bfs;

import java.io.*;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17394 {
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.println(snap(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

    }

    public static int snap(int start, int a, int b) {
        findPrimeArr(a,b);
        visited = new boolean[2000000];// 0 1 2 ... b

        Point p = new Point(start, 0);
        visited[start] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(p);
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            if (poll.lifeCount <= b && a <= poll.lifeCount && arr[poll.lifeCount] != 0) {
                return poll.mvCount;
            }

            if (!visited[poll.lifeCount/2]) {
                queue.offer(new Point(poll.lifeCount / 2, poll.mvCount + 1));
                visited[poll.lifeCount / 2] = true;
            }
            if (!visited[poll.lifeCount/3]) {
                queue.offer(new Point(poll.lifeCount / 3, poll.mvCount + 1));
                visited[poll.lifeCount / 3] = true;
            }
            if (poll.lifeCount< 100000 && !visited[poll.lifeCount+1]) {
                queue.offer(new Point(poll.lifeCount + 1, poll.mvCount + 1));
                visited[poll.lifeCount + 1] = true;
            }
            if (poll.lifeCount > 0 && !visited[poll.lifeCount-1] ) {
                queue.offer(new Point(poll.lifeCount - 1, poll.mvCount + 1));
                visited[poll.lifeCount-1] = true;
            }


        }
        return -1;
    }

    public static void findPrimeArr (int a, int b) {// 0이면 소수가 아니다 !=0인 애들이 소수
        arr = new int[b+1];
        for (int i = 2; i <= b; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= b; i++) {
            for (int j = i*2; j <=b; j+=i) {
                if (arr[j] == 0) continue;//j가 0이라면 이전에 약수에 의해 쓸려간 것
                arr[j] = 0;
            }
        }
    }

    public static class Point {
        int lifeCount;
        int mvCount;

        Point (int lifeCount, int mvCount) {
            this.lifeCount = lifeCount;
            this.mvCount = mvCount;
        }
    }
}
