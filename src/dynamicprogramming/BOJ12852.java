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

        for(int i = 2; i < n + 1; i++) {//bottomup 방식으로 할거에요~
            answers[i] = answers[i-1] + 1;//기본은 바로 이전에서 하나 더함
            before[i] = i-1;//이 경우에는 before도 바로 전 거
            if(i % 2 ==0 && answers[i] > answers[i/2] + 1) {//만약 2의 배수이고 최소 횟수가 적다면 갱신
                answers[i] = answers[i/2] + 1;
                before[i] = i/2;
            }
            if(i % 3 ==0 && answers[i] > answers[i/3] + 1) {//만약 3의 배수이고 최소 횟수가 적다면 갱신
                answers[i] = answers[i / 3] + 1;
                before[i] = i / 3;
            }
            //왜 탑다운에서는 6의 배수 했는데 bottomup에서는 6의 배수 안해?
            //topdown때는 재귀로 들어가버림 내가 한 수에 대해 2의 배수, 3의 배수 모두 체크할 수 없었움
            //하지만 bottomup에서는 각 수에 대해 2의 배수인지 3의 배수인지 모두 체크 가능 고로 bottomup에서는 6의 배수 신경 안써도 됨

        }

        System.out.println(answers[n]);
        int temp = n;
        for(int i = 0; i <= answers[n]; i++) {
            System.out.print( temp + " ");
            temp = before[temp];
        }
    }
}
