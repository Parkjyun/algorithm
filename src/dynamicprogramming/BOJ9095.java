package dynamicprogramming;

import java.util.Scanner;
//dp는 규착을 찾아라
public class BOJ9095 {
    static int n;
    static int[] answers;
    static int[] candidtates;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        candidtates = new int[n];
        answers = new int[10];
        answers[0] = 1;
        answers[1] = 2;
        answers[2] = 4; //3 -> 7
        for(int i = 0; i < n; i++) {
            candidtates[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            System.out.println(find(candidtates[i] - 1));
        }
    }
    static int find(int candidate) {
        if(answers[candidate] == 0) { //초기화가 되어 있지 않다면
            return find(candidate - 1) + find(candidate - 2) + find(candidate - 3);
        } else {
            return answers[candidate];
        }

    }
}
