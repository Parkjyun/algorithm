package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] time = new int[n];//0이 시간
        int[] money = new int[n];
        int[] dp = new int[n+1]; // dp에는 n일 차에 가질 수 있는 돈

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            time[i] = t;
            money[i] = p;
        }
        //i일자까지 근무했을 때의 최대 비용

        for (int i = 0; i < n; i++) {//dp[1] - dp[n]까지
            if(i + time[i] < n + 1 ) { //일을 할 수 있다.
                dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + money[i]);
            }
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }
        System.out.println(dp[n]);
    }

}
