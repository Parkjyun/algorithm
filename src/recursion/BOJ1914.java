package recursion;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ1914 {
    static long count = 0;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        BigInteger bI = new BigInteger("2").pow(n).subtract(new BigInteger("1"));
        sb.append(bI + "\n");
        if(n <= 20) {
            hanoi(n, 1, 3, 2);
        }
        System.out.print(sb);

    }

    static void hanoi(int n, int start, int obj, int temp) {
        if(n == 1) {
            sb.append(start + " " + obj + "\n");
        }
        else {
            hanoi(n - 1, start, temp, obj);
            sb.append(start + " " + obj + "\n");
            hanoi(n - 1, temp, obj, start);
        }
    }
}
