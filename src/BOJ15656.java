import java.util.Arrays;
import java.util.Scanner;

public class BOJ15656 {//중복순열 중복가능-> visited 없음, 순열 -> 순서 상관있음 사전

    static int n;
    static int m;
    static int[] givenSet;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        givenSet = new int[n];
        for(int i = 0; i < n; i++)
            givenSet[i] = sc.nextInt();
        Arrays.sort(givenSet);
        answer = new int[m];


        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        //출력부
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            answer[depth] = givenSet[i];
            dfs(depth + 1);
        }
    }
}
