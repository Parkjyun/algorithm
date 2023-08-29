package dynamicprogramming;

import java.util.Map;
import java.util.Scanner;

public class BOJ1932 {
    static int[][] givenSet;
    static int n;
    static Integer[][] answers;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        givenSet = new int[n+1][];
        answers = new Integer[n+1][];
        for(int i = 1; i < n + 1; i++) {
            givenSet[i] = new int[i+1];
            answers[i] = new Integer[i+1];
            for(int j = 1;j < givenSet[i].length; j++)
                givenSet[i][j] = sc.nextInt();
        }
        answers[1][1] = givenSet[1][1];

        for(int i = 2; i < givenSet.length; i++) {
            for(int j = 1; j < givenSet[i].length; j++) {
                dp(i,j);
            }
        }
        for(int i = 1; i < answers[n].length; i++) {
            if(max < answers[n][i])
                max = answers[n][i];
        }
        System.out.println(max);

    }
    static void dp(int i, int j) {
        if(j == 1) answers[i][j] = answers[i-1][j] + givenSet[i][j];
        else if(j == answers[i].length - 1) answers[i][j] = answers[i-1][j-1] + givenSet[i][j];
        else answers[i][j] = Math.max(answers[i-1][j-1], answers[i-1][j]) + givenSet[i][j];
    }
}
