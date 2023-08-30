package dynamicprogramming;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ12852 {
    static int n;
    static Integer[] answers;
    static int[] before;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        answers = new Integer[n+1];
        before = new int[n+1];
        answers[1] = 0;
        before[1] = 1;
        for(int i = 2; i < n + 1; i++) {
            answers[i] = answers[i-1] + 1;
            before[i] = i-1;
            if(i % 2 ==0 && answers[i] > answers[i/2] + 1) {
                answers[i] = answers[i/2] + 1;
                before[i] = i/2;
            }
            if(i % 3 ==0 && answers[i] > answers[i/3] + 1) {
                answers[i] = answers[i / 3] + 1;
                before[i] = i / 3;
            }
        }

        System.out.println(answers[n]);
        int temp = n;
        for(int i = 0; i <= answers[n]; i++) {
            System.out.print( temp + " ");
            temp = before[temp];
        }
    }
}
