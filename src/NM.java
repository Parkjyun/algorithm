import java.util.Scanner;



public class NM {
    private static int[] ans;
    private static boolean[] tf;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        ans = new int[m];//답은 m개를 요구한다
        tf = new boolean[n];//총수의 개수인 n개에 대해서 tf를 저장 , visited = true

        dfs(n,m,0);
    }
    private static void dfs(int n, int m, int depth) {
        if(depth == m) {//만약 depth가 m개가 되면 정답을 출력한다
            for (int ans: ans) {
                System.out.print(ans + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++) {
            if(tf[i] == false) {//만약 i번째 수가 방문되지 않은 것이라면
                ans[depth] = i + 1;//depth에 i번째수를 넣는다
                tf[i] = true;//그리고 I번째 수는 방문 됐으니 true로 바꾸고
                dfs(n, m, depth + 1);//2번째수를 찾으러간다
                tf[i] = false;
            }
        }



    }
}
