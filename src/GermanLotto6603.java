import java.util.Scanner;

public class GermanLotto6603 {

    static int k;
    static int[] givenSet;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            k = sc.nextInt();
            if(k == 0) break;
            givenSet = new int[k];
            visited = new boolean[k];

            for(int i = 0; i < givenSet.length; i++) {
                givenSet[i] = sc.nextInt();
            }
            dfs(0, 0);
            System.out.println();
        }
    }

    //1234567중에서 6개를 뽑는다
    //이때 7c6을 수행하고 출력은 사전순으로 출력
    private static void dfs(int depth, int start) {
        //출력부
        if(depth == 6) {
            for(int i = 0; i < visited.length; i++) {
                if(visited[i])
                    System.out.print(givenSet[i] + " ");
            }
            System.out.println();

        }
        for(int i = start; i < givenSet.length; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }


    }
}
