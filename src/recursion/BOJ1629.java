package recursion;

import java.math.BigInteger;
import java.util.Scanner;
//시간복잡도를 고려하여 부분정복 사용
public class BOJ1629 {
    static long a;
    static long b;
    static long c;
    //27 % 4 = 3
    // 3 % 4 *3 % 4 *3 % 4 *
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        long answer = recursion(b) % c;

        System.out.println(answer);

    }
    static long recursion(long b) {
        if(b == 0) {
            return 1;
        }
        long n = recursion(b/2);
        if(b % 2 == 0) //짝수라면
            return n*n % c;
        else
            return (n*n%c) * a % c;

    }
}
