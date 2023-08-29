package dynamicprogramming;

import java.util.Scanner;

public class BOJ1912 {
    static int[] givenSet;
    static Integer[] answer;
    static int n;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        givenSet = new int[n];
        answer = new Integer[n];
        for(int i = 0; i < n; i++) {
            givenSet[i] = sc.nextInt();
        }
        answer[0] = givenSet[0];
        max = givenSet[0];
        dp(n-1);
        System.out.println(max);

    }
    static int dp(int i) {
        if(answer[i] == null) { //만약 answers가 초기화 되지 않았다면
            answer[i] = Math.max(dp(i-1) + givenSet[i], givenSet[i]);
            max = Math.max(answer[i], max);
        }
        return answer[i];
    }

}
