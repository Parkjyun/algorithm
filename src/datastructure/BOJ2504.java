package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;

public class BOJ2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Deque<Character> stack = new java.util.ArrayDeque<>();
        int result = 0;
        int temp = 0;
        int weight = 1;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == '(') {
                weight *= 2;
                temp = weight;

                stack.push('(');
            } else if (c == '[') {
                weight *= 3;
                temp = weight;
                stack.push('[');
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    weight /=2;
                    stack.pop();
                }
                if (s.charAt(i-1) == '(') {
                    result += temp;
                }

            } else if (c == ']') {
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                if (!stack.isEmpty() && stack.peek() == '[') {
                    weight /=3;
                    stack.pop();
                }
                if (s.charAt(i-1) == '[') {
                    result += temp;
                }

            }
        }
        if (!stack.isEmpty())
            System.out.println(0);
        else
            System.out.println(result);

    }
}
