package programmers.dp;

public class 타일링2N {
    public int solution(int n) {
        //dp[n]은 가로가 n일 때 가능 종류
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        int a = 1000000007;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] % a + dp[i-2] % a;
        }
        return dp[n] % a;
    }
}
