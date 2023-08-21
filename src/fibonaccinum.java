import java.util.Scanner;

public class fibonaccinum {
    //결국 0,1이 일어나는 횟수도 피보나치 수열을 따라간다.
    //왜와이? 예를 들어 5 = 4 + 3 -> 이때 4 = 3 + 2자나 여기서 1이 발생하는 수 피보나치자나
    public static void main(String[] args) {
        int[][] dp = new int[41][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int i = 2; i < 41; i++) {//d[n]마다 0,1 다 만들어놔
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
        int[] tests = new int[test];
        for(int i = 0; i < test; i++) {
            tests[i] = sc.nextInt();
        }
        for(int i = 0; i < test; i++) {
            System.out.println(dp[tests[i]][0] + " " + dp[tests[i]][1]);
        }
    }
}
