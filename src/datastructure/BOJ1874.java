package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> stack = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int max = 0;

        for (int i = 1; i < n+1; i++) {
            int target = Integer.parseInt(br.readLine());
            if (target > max) {
                int t = target - max;
                for (int j = 0; j < t; j++) {
                    stack.push(++max);
                    sb.append("+").append("\n");
                    if (j ==t-1) {
                        stack.pop();
                        sb.append("-").append("\n");
                    }
                }
            } else {
                if (stack.peek() == target) {
                    stack.pop();
                    sb.append("-").append("\n");
                    max = Math.max(target, max);

                    continue;
                }
                while (stack.peek() != target) {
                    stack.pop();
                    sb.append("-").append("\n");

                    if (stack.size() == 0) {
                        System.out.print("NO");
                        return;
                    }
                }
            }
            max = Math.max(target, max);
        }
        System.out.print(sb);
    }
}
