package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7570 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];//n은 사람한테 적힌 번호, val은 해당 번호에서 연속적으로(2345)증가한 수의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            int curNum = Integer.parseInt(st.nextToken());
            dp[curNum] = dp[curNum-1] + 1;
        }

        //각각의 index에서의 최장 증가 수열을 구함
        Arrays.sort(dp);
        System.out.println(n-dp[n]);
    }
}
