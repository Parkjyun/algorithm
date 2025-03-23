package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            Deque<Character> stack = new ArrayDeque<>();
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                char letter = s.charAt(j);
                if (stack.peek() == null || letter != stack.peek()) {
                    stack.push(s.charAt(j));
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }

        }
        System.out.println(answer);
    }
}
