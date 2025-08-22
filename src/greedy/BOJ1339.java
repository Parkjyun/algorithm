package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1339 {
    static int[] degree = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //문자별로 가중치를 놓느다.
        // a b c d e f g h i j

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                degree[s.charAt(j) - 'A'] += (int) Math.pow(10, s.length() - 1 - j);
            }
        }
        int[] array = Arrays.stream(degree).boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();
        int num = 9;
        int answer = 0;
        for (int i : array) {
            answer += num*i;
            num--;
        }
        System.out.println(answer);
    }


    }