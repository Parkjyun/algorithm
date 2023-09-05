package dynamicprogramming;

import java.util.Scanner;
//극장 좌석은 1~n
//if 자기 좌석이 i -> i-1, i+1가능 -> 바로 옆자리와 스위칭만 가능하다
//if vip -> 자기 좌석에만
//자리     1 2 3 4 5 6 7 8 9
//배치     1 2 3 4 5 6 7 8 9
//        1 2 3 4 5 6 7 8 9
//        1 2 3 4 5 6 7 8 9
//        1 2 3 4 5 6 7 8 9
//        1 2 3 4 5 6 7 8 9
//        1 2 3 4 5 6 7 8 9
//        1 2 3 4 5 6 7 8 9
//        1 2 3 4 5 6 7 8 9
//        1 2 3 4 5 6 7 8 9
//        1 2 3 4 5 6 7 8 9
//        1 2 3 4 5 6 7 8 9
//        1 2 3 4 5 6 7 8 9
//dp[2] = 2
//12
//21
//        dp[n] = dp[]
//dp[3] = 3
//123
//213
//132
//dp[4] = 5
//1234
//2134
//1324
//1243
//2143
//dp[5] = 8
//12345
//21345
//13245
//12435
//12354
//21435
//13254
//21354
//dp[6] = 13
//123456 -> 13
//21
//---1개만 -> 5
//--2개
//13
//14
//15
//24
//25
//35 ->6
//3개
//135 -> 1
//그냥

public class BOJ2302 {
    static int n;
    static int[] dp;
    static boolean[] vip;
    static int answer;

    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+1];//dp는 연속된 자리의 조합수 dp3은 3개의 자리가 이동가능할때
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        int vC = sc.nextInt();
        vip = new boolean[n+2];
        for(int i = 0; i < vC; i++) {
            vip[sc.nextInt()] = true;
        }
        vip[n+1] = true;

        answer = 1;
        count = 0;
        for(int i = 1; i <= n+1; i++) {

            if(vip[i] || i ==n+1) {
                answer *= dp[count];
                count = 0;
            } else {
                count++;
            }

        }
        System.out.print(answer);




    }
}
