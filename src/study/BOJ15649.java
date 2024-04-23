package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int[] choose;
    static int[] givenNumber;
    static boolean[] visited;
    static int m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //1부터 n까지 중복없이 m개를 고른 수열
        choose = new int[m];
        givenNumber = new int[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i < givenNumber.length; i++) {
            givenNumber[i] = i;
        }
        dfs( 0);
        System.out.println(sb);
    }
    //깊이우선 탐색 + backtracking이다.
    //한놈만 패다가 이새끼 아닌거 같으면 올라와라
    //1-n까지 내려가자
    private static void dfs(int depth) {//1부터 n까지 m개를 고른 수열, 고르는 애들의 index는 0-1 나머지 숫자들은 1-n
        if (depth == m) {//m개를 채웠다면 출력
            for (int i = 0; i < choose.length; i++) {
                sb.append(choose[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i < givenNumber.length; i++) {//후보숫자들 중에서
            if (!visited[i]) {//방문하지 않은 곳이라면
                visited[i] = true;//방문처리하고
                choose[depth] = i;//방문한 놈들 모아 놓는 배열에 넣고
                dfs(depth+1);//depth를 늘려 한번 더 수행한다
                visited[i] = false;//상위 depth에서 빠져 나온다면 다시 방문 처리를 푼다 -> 왜 와이? 1 -> 234 false
            }
        }
    }

}
