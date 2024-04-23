package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());
        //김과 림의 번호가 주어졌을 때 몇 라운드에서 만나게 되는지
        //1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
        // 1   2   3   4   5     6     7    8
        //   1       2        3            4
        //12 -> 1   34 -> 2     56 -> 3
        int round = 0;// 16 1 2 -> 1라운드에서 만남
        while (kim!= lim) {//같지 않을 때까지 계속한다
            kim = kim/2 + kim%2;
            lim = lim/2 + lim%2;
            round++;
        }
        System.out.println(round);
    }
}
