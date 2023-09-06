package dynamicprogramming;

import java.util.Scanner;
//dp[1][3] = dp[1][1] + dp[1][2] + map[1][3];
public class BOJ11660 {
    static int n;
    static int m;
    static int map[][];
    static int dp[][];
    static int[][] xs;
    static int[][] ys;
    static int answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n+1][n+1];
        dp = new int[n+1][n+1];
        xs = new int[m+1][3];
        ys = new int[m+1][3];

        for(int i = 1; i <=n; i++) {//조합을 넣음
            for(int j = 1; j <=n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for(int i = 1; i <= m; i++) {
            xs[i][1] = sc.nextInt();
            ys[i][1] = sc.nextInt();
            xs[i][2] = sc.nextInt();
            ys[i][2] = sc.nextInt();
        }
//        n은 map의 한변의 갯수
//        m은 총실행 횟수;
//        xs, ys는 각각 좌표를 갖고 있는 조합
//dp[x][y]는 dp[x][1] + dp[x][2] + ... +  d[x][y]
//        만약 2,2, 3,4
        //dp
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1] + map[i][j];
            }
        }

        //답
        for(int i = 1; i <= m; i++) {//총 m번의 계산을 하겠다.
            answer = 0;
            for(int j = xs[i][1]; j <= xs[i][2]; j++) {//m번의 회차 중 각회차의 2만큼
//                1회차의 x좌표 2개 xs[i][2] xs[i][1]  y좌표는 ys[i][1] ys[i][2]
                answer += dp[j][ys[i][2]] - dp[j][ys[i][1]-1];
            }
            sb.append(answer + "\n");
        }

        System.out.print(sb);

    }
}
