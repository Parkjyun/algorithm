package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11047RE {
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
        Collections.sort(coins, (o1, o2) -> o2 - o1);// 내림차순 정렬

        for(int coin : coins) {
            if (coin > val) continue;

            while (val >= coin) {
                val-=coin;
                count++;
            }
        }
        System.out.println(count);
    }
}
