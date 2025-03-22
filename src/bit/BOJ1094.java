package bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1094 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        //x를 이진수로 표현했을 때 몇개의 x가 있는가
        // 이때 이진수는 64까지ㅣㄴ 1000000 자리수

        int answer = 0;
        for (int i = 0; i < 7; i++) {//&연산할 때 자리수까지 해서 연산 결과 나옴
            if ((x & (1 << i)) != 0) answer++;
        }
        System.out.println(answer);
    }

}
