import java.util.Scanner;

//자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//
//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
//고른 수열은 오름차순이어야 한다.
public class BOJ15650 {
    static int n;
    static int m;
    static int[] set;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        set = new int[n];
        visited = new boolean[n];

        for(int i = 0; i < set.length; i++) {
            set[i] = i + 1;
        }

        dfs(0, 0);


    }

    private static void dfs(int depth, int start) {
        //출력부
        if(depth == m) {
            for(int i = 0; i < visited.length; i++) {
                if(visited[i])
                    System.out.print(set[i] + " ");
            }
            System.out.println();
        }

        for(int i = start; i < set.length; i++) {
            if(visited[i] == false) {
                visited[i] =true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
