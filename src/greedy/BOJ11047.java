package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11047 {
    //n종류의 동전 -> 가치의 합을 k로
    //이후 n개의 줄에 동전의 가치가 주어짐
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int val = Integer.parseInt(st.nextToken());
        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < num; i++)
            coins.add(Integer.parseInt(new StringTokenizer(br.readLine()).nextToken()));
        Collections.sort(coins, Collections.reverseOrder());

        for (int coinVal:
             coins) {
            if(coinVal > val) continue;//코인이 돈보다 크다면 넘어간다. 코인이 돈보다 작거나 같다면 while문 돔
            //코인의 가치가 주어진 돈보다 작다면
            while(val >= coinVal) {//돈이 코인보다 크다면 계속함 + 같을 때는 한번더 해도 되니깐 while문 돔 -> 같을 때 돌면 끝남
                val -= coinVal;
                count++;
            }
        }
        System.out.println(count);
    }
}

