package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1325 {
    static int[] count;
    static List<Integer>[] adj;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        count = new int[n]; //각 노드에서 해킹할 수 있는 컴퓨터 수
        adj = new ArrayList[n]; //각 노드에서 해킹할 수 있는 컴퓨터들
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            adj[a].add(b); // a가 b를 해킹할 수 있다.
            //자식, 부모
        }
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, count[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (count[i] == max) {
                stringBuilder.append((i + 1) + " ");
            }
        }
        System.out.println(stringBuilder);

    }

    static void dfs(int start) {
        count[start]++;
        visited[start] = true;


        /*
        * 자식 start에서 실행. 역방향으로 올라가며 !visited라면 count++, visited , 이외 전부 탐색
        * */

        for (int to : adj[start]) { // 내부모들
            if (visited[to]) continue;

            dfs(to);
        }
    }
}
