package dynamicprogramming;

import java.util.Scanner;

public class BOJ2748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long sum = 1;
        long f1 = 0;
        long f2 = 1;


        for (int i = 1; i < n; i++) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        System.out.println(sum);
    }


}
