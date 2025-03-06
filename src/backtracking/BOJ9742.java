package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ9742 {
    static boolean[] visited;
    static int sequence;
    static StringBuilder sb;
    static String str;
    static String line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;
        while ((line = br.readLine()) != null) {

            st = new StringTokenizer(line);
            str = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            visited = new boolean[str.length()];
            sequence = 0;
            sb = new StringBuilder();

            int mul = 1;
            int length = str.length();
            while (length > 0) {
                mul *= length;
                length--;
            }
            if (mul < n) {
                System.out.println(str + " " + n + " = No permutation");
                continue;
            }

            char[] result = new char[str.length()];
            dfs(0, n, result);
            System.out.println(sb);
        }
    }

    private static void dfs(int depth, int objSequence, char[] result) {

        if (depth == visited.length) {
            sequence++;
            if(sequence == objSequence) {
                sb.append(str).append(" ").append(objSequence).append(" = ").append(result);
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = str.charAt(i);
                dfs(depth+1, objSequence, result);
                visited[i] = false;
            }
        }
    }
}
