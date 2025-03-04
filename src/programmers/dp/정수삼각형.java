package programmers.dp;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        //i번째 줄까지 가는데 거쳐간 숫자의 최댓값
        int[][] dp = new int[triangle.length + 1][];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = new int[i+1];
        }


        dp[1][1] = triangle[0][0];

        for (int i = 2; i < dp.length; i++) {//각각의 row에 대해서
            for (int j = 1; j < dp[i].length; j++) {
                //i번째 줄 j번째 방문할 때 최댓 값은?
                if (j == 1) {
                    dp[i][j] = triangle[i-1][j-1] + dp[i-1][1];
                }
                if(j == dp[i].length - 1) {
                    dp[i][j] = triangle[i-1][j-1] + dp[i-1][dp[i].length - 2];
                }
                if(j >= 2 && j < dp[i].length - 1)
                    dp[i][j] = triangle[i-1][j-1] + Math.max(dp[i-1][j-1], dp[i-1][j]);

            }

        }

        for(int last : dp[triangle.length]) {
            answer = Math.max(answer, last);
        }
        return answer;
    }
}
