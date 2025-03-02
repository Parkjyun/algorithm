package implementation;

import java.io.BufferedReader;
import java.io.IOException;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String[] split = br.readLine().split("-");

        int result = Integer.MAX_VALUE;
        int temp;
        for (String s : split) {// - 기준으로 나눈 문자열들
            String[] splitPlus = s.split("\\+");
            temp = 0;
            for (String s1 : splitPlus) {
                temp += Integer.parseInt(s1);
            }
            if (result == Integer.MAX_VALUE) {
                result = temp;
            } else {
                result -= temp;
            }


        }
        System.out.println(result);

    }
}
