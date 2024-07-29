package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2893 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());

        int answer = 0;
        int m = 0;
        answer = k / 5;//가방개수
        m = k % 5;
        if (k == 4) sb.append(-1);
        if (m % 3 == 0) {
            answer += m/3;
            sb.append(answer);
        } else {//남은 것이 나우어떨어지지 않느다면
            int count = 2;
            while (answer > 0 && count > 0) {
                count -= 1;
                answer -= 1;
                m += 5;
                if (m%3 == 0) {
                    answer += m / 3;
                    sb.append(answer);
                    break;
                } else if(count == 0 || answer == 0)
                    sb.append(-1);
            }
        }
        System.out.println(sb);

    }
}
