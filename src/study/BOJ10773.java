package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int zeroCount = 0;
        int sum = 0;
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            //0이라면 zerocount ++
            if (pop == 0) {
                zeroCount++;
            }
            if (pop != 0 ) { // 0이 아니라면
                if (zeroCount > 0)
                    zeroCount--;
                else if (zeroCount == 0) {
                    sum += pop;
                }
            }
        }
        System.out.println(sum);
    }
}
