package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759Re {
    static boolean[] visited;
    static int n;
    static int m;
    static String[] map;
    static String[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //n은 골라야 되는 수, m은 조합 문자열의 수
        // 사전순으로 중복없이 -> visited
        // 나보다 큰 것들만 -> before
        //최소 한개의 모음과 두개의 자음
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[m];
        answer = new String[n];
        visited = new boolean[m+1];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            map[i] = st.nextToken();
        }
        Arrays.sort(map);

        dfs(1,0);
        System.out.println(sb);

    }

    static void dfs(int before, int depth) {
        if (depth == n) {
            if (validation(answer)) {

            for (int i = 0; i < answer.length; i++) {
                sb.append(answer[i]);
            }
            sb.append("\n");
             }
            return;

        }

        for (int i = before; i <= m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = map[i-1];
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }

    static boolean validation(String[] answer) {
        int mCount = 0;
        int jCount = 0;
        for (String s : answer) {
            if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
                mCount++;
            }
            else {
                jCount++;//모음만 5개야. 그래도 통과 !! 두개의 조건 모두 필요
            }
        }

        return mCount >= 1 && jCount >= 2;

    }
}
