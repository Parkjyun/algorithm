package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                stack.push(s.charAt(j));
            }
            //1개 로직
            int lC = 0;
            int rC = 0;
            int rFC = 0;
            while (!stack.isEmpty()) {
                if (stack.peek() == '(') {
                    stack.pop();
                    lC++;
                    if (rC > 0) rC--;
                } else if (stack.peek() == ')') {
                    stack.pop();
                    rC++;
                    rFC++;
                }
            }
            if (rC == 0 && (lC == rFC)){ sb.append("YES").append("\n");}
            else sb.append("NO").append("\n");

        }
        System.out.println(sb);
    }
}
