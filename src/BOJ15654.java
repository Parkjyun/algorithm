import java.util.Arrays;
import java.util.Scanner;

public class BOJ15654 {
    //중복 있으면 안돼 -> visited, 17, 71 다른 것으로 취급 ,사전순으로 증가 -> start 조절
    static int n;
    static int m;
    static int[] givenSet;
    static boolean[] visited;

    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        m = sc.nextInt();

        givenSet = new int[n];
        visited = new boolean[n];
        answer = new int[m];

        for (int i = 0; i < n; i++) {
            givenSet[i] = sc.nextInt();
        }
        Arrays.sort(givenSet);

        dfs(0);
        System.out.println(sb);
    }
//m개의 수중에서 n개를 골라야 한다 12 13 14 21 23 24 ... 중복은 허용되지 않으며 순서는 상관이 있고
    static void dfs(int depth) {
        //출력부
        if(depth == m) {
            for(int i = 0; i < m; i++)
                sb.append(answer[i] + " ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                answer[depth] = givenSet[i];
                dfs(depth + 1);
                visited[i] = false;

            }
        }
    }
//1789
}
