import java.util.Arrays;
import java.util.Scanner;
//콤비네이션 -> 중복 x -> visited 필요, start넣어서 i + 1
public class BOJ15655 {
    //4c2 오름차순으로 표현 -> 중복 있으면 안 되고 조합
    static int n;
    static int m;
    static int[] givenSet;

    static boolean[] visited;

    static int[] answer;
    static StringBuilder sb =new StringBuilder();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        givenSet = new int[n];
        visited = new boolean[n];
        answer = new int[m];

        for(int i = 0; i < n; i++) {
            givenSet[i] = sc.nextInt();
        }

        Arrays.sort(givenSet);

        dfs(0,0);
        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        //출력부
        if(depth == m) {
            for(int  i = 0; i < m; i++)
                sb.append(answer[i] + " ");
            sb.append("\n");
            return;
        }

        for(int i = start; i < n; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                answer[depth] = givenSet[i];
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

}
