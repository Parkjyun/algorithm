import java.util.Scanner;
//!!Sysyem.out.println을 쓰는 것 보다 Stringbuilder를 쓰는 것이 이롭다
public class BOJ15651 {
    static int n;
    static int m;
    static int[] set;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        set = new int[n];
        answer = new int[m];
        for(int i = 0; i < n; i++)
            set[i] = i + 1;

        dfs(0);
        System.out.println(sb);

    }
    static void dfs(int depth) {
        //출력부
        if(depth == m) {
            for (int i = 0; i < answer.length; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i =0; i < set.length; i++) {
            answer[depth] = i + 1;
            dfs(depth + 1);
        }

    }
}
