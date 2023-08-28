package dynamicprogramming;

import javax.swing.*;
import java.util.Scanner;

public class BOJ1463 {
    static Integer[] answers;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        answers = new Integer[n+1];//초기화시 값으로 모두 null 고로 따로 초기화가 되지 않았따면 null임
        answers[1] = 0;//재귀 호출시 재귀를 끝내기 위해 필요
        for(int i = 2; i <= n; i++) {//자연수 2-n까지 필요한 수를 구한다.
            dp(i);
        }
        System.out.println(answers[n]);
    }
    static int dp(int n) {
        if(answers[n] == null) {//만약 index에 대해 계산이 안 되어 있다면
            if (n % 6 == 0) {//6의 배수부터 분기나누는 이유 : 만약 2or3으로 먼저 나누면 나중에 6의 배수를 sorting할 수 없다.
                answers[n] = Math.min(dp(n / 3) + 1, Math.min(dp(n / 2) + 1, dp(n - 1) + 1));
            } else if (n % 3 == 0) {
                answers[n] = Math.min(dp(n / 3) + 1, dp(n - 1) + 1);
            } else if (n % 2 == 0) {
                answers[n] = Math.min(dp(n / 2) + 1, dp(n - 1) + 1);
            } else {
                answers[n] = answers[n - 1] + 1;
            }
        }

        return answers[n];
    }



}
