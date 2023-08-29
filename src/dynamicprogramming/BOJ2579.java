package dynamicprogramming;

import java.util.Scanner;

public class BOJ2579 {
    static int[] stairs;
    static Integer[] answers;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        stairs = new int[n + 1];
        answers = new Integer[n + 1];

        count = 1;
        for(int i = 1; i < n + 1; i++) {
            stairs[i] = sc.nextInt();
        }
        answers[0] = 0;
        answers[1] = stairs[1];
        if(n >= 2) {
            answers[2] = stairs[1] + stairs[2];
        }
        dp(n);
        System.out.println(answers[n]);
    }
    static int dp(int n) {
        if(answers[n] == null) { //만약 아직 초기화가 되지 않았다면
            answers[n] = Math.max(dp(n-2), dp(n-3) + stairs[n-1]) + stairs[n];
            //2계단 전은 그냥 dp(n-2) 호출한다
            //1계단 전은 dp(n-3) + stairs[n-1]로 호출한다
            //1계단 전 왜 바로 dp(n-1)로 하지 않아?
            //만약 dp(n-1)로 한다면 이것이 n-2 n-1 n인지 n-3 n-1 n인지 판별이 안 된다, 만약 전자로 들어온 경우라면 3연속이니 불가능
            //고로 따로 계산을 해주어 dp[n-3] + stairs[n-1] -> 3연속이 안나오도록 보장해야 한다.

        }
        return answers[n];
    }
}
