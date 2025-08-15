package programmers.dp;

public class 스티커모으기 {
    public int solution(int sticker[]) {
        int answer = 0;
        if (sticker.length == 1) return sticker[0];
        int dp1[] = new int[sticker.length + 1];
        int dp2[] = new int[sticker.length + 1];

        dp1[1] = sticker[0];
        dp2[2] = sticker[1];

        //dp[i] = dp[i-2] + arr[i], dp[i-1]
        for (int i = 2; i < sticker.length; i++) {//length-2까지
            dp1[i] = Math.max(dp1[i-2] + sticker[i-1], dp1[i-1]);
        }

        for (int i = 3; i < sticker.length+1; i++) {//
            dp2[i] = Math.max(dp2[i-2] + sticker[i-1], dp2[i-1]);
        }

        return Math.max(dp1[sticker.length-1], dp2[sticker.length]);
    }
}
