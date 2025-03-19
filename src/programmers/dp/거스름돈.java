package programmers.dp;

public class 거스름돈 {
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int m : money) {
            for (int j = 1; j < dp.length; j++) {
                if (j -m >= 0)
                    dp[j] = (dp[j] + dp[j - m]) % 1000000007;
            }
        }
        return dp[n] % 1000000007;
    }
}
