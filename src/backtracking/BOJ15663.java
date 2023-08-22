package backtracking;

import java.util.Arrays;
import java.util.Scanner;

//순열 + 오름차순, 중복 x -> visited 필요, 전체적으로는 오름차순,   각 항이 오름차순일 필요는 없음 -> start필요 없음
//before는 activation record마다 독립적으로 유지 -> depth마다 before는 따로 관리됨
public class BOJ15663 {
    static int n;
    static int m;
    static int[] givenSet;
    static boolean[] visited;
    static int[] answer;

    static int count;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        givenSet = new int[n];
        visited = new boolean[n];
        answer = new int[m];
        for(int i = 0; i < n; i++)
            givenSet[i] = sc.nextInt();
        Arrays.sort(givenSet);
        dfs(0);
        System.out.println(sb);

    }

    static void dfs(int depth) {
        //출력부
        if(depth == m) {
                for (int i = 0; i < m; i++)
                    sb.append(answer[i] + " ");

                sb.append("\n");
                return;
            }
        int before = 0;
        for(int i = 0; i < givenSet.length; i++) {
                if (visited[i] == false && before != givenSet[i]) {//방문하지 않았고 이번에 뽑은게 직전이랑 중복되지 않는다면
                    visited[i] = true;
                    before = givenSet[i];
                    answer[depth] = givenSet[i];
                    dfs(depth + 1);
                    visited[i] = false;
                }
        }
    }
}

