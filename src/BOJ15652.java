import java.util.Scanner;
//중복 없이 -> visited를 따로 쓰지 않아도 된다.
//오름차순 -> 정답 배열에 수를 더할 떄 i = start부터
//11 22 33 44는 가능하므로 다음 dfs로 넘어갈때 start는 1을 더하지 않음
public class BOJ15652 {
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
        answer = new int[m];

        for(int i = 0; i < givenSet.length; i++) {
            givenSet[i] = i + 1;
        }

        dfs(0,0);
        System.out.println(sb);

    }

    static void dfs(int depth, int start) {
        if(depth == m) {
            for(int i = 0; i < answer.length; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < givenSet.length; i++) {
            answer[depth] = i + 1;
            dfs(depth + 1, i);
        }
    }
}
