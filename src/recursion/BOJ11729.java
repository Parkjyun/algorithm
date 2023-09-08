package recursion;

import java.util.Scanner;

public class BOJ11729 {
    static int n;
    static int answer = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        hanoi(n,1,3,2);
        System.out.println(answer);
        System.out.print(sb);


    }
    static void hanoi(int n, int start, int obj, int temp) {
        if(n == 1) {
            answer++;
           sb.append(start +  " " + obj + "\n");

        } else {
            hanoi(n - 1, start, temp, obj);
            answer++;
            sb.append(start + " " + obj + "\n");
            hanoi(n - 1, temp, obj, start);
        }
    }
}
