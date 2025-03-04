package programmers.dp;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        //dp[i][j] == x가 i, y가 j일때 해당 자리까지 올수 있는 길의 수
        //만약 퍼들이라면 dp를 -1로
        int[][] dp = new int[n+1][m+1];
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        dp[1][1] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(dp[i][j] == -1) continue; //웅덩이라면
                if(dp[i-1][j] > 0) {//위가 웅덩이가 아니라면 또는 index가 0이 아니라면(값 0 이니)
                    dp[i][j] += dp[i-1][j] % 1000000007;
                }
                if(dp[i][j-1] > 0) {// 왼쪽이 웅덩이가 아니라먄
                    dp[i][j] += dp[i][j-1] % 1000000007;
                }
            }
        }
        return dp[n][m] % 1000000007;
    }
}
