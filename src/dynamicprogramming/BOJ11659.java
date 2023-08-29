package dynamicprogramming;

import java.util.Scanner;

public class BOJ11659 {
    static int[] givenSet;
    static Integer[] answers;
    static int[] is;
    static int[] js;
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        givenSet = new int[n+1];
        answers = new Integer[n+1];
        is = new int[m+1];
        js = new int[m+1];

        for(int i = 1; i <n + 1; i++) {
            givenSet[i] = sc.nextInt();
        }
        for(int i = 1; i < m + 1; i++) {
            is[i] = sc.nextInt();
            js[i] = sc.nextInt();
        }
        answers[0] = 0;
        answers[1] = givenSet[1];
        dp(n);
        for(int i = 1; i < m + 1; i++) {
           System.out.println(answers[js[i]] - answers[is[i]-1]);
        }


    }
    static int dp(int i) {
        if(answers[i] == null) {
            answers[i] = dp(i-1) + givenSet[i];
        }
        return answers[i];
    }
}
