package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String str = br.readLine();
        String b = br.readLine();
        char e = b.charAt(b.length()-1);
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= b.length() && stack.peek() == e) {//폭탄 수보다 스택이 크고 끝이 폭탄일 때만
                StringBuilder sb = new StringBuilder();
                for (int a = 0; a < b.length(); a++) {
                    sb.append(stack.pop());
                }
                String reversed = sb.reverse().toString();
                //System.out.println(reversed);
                if (!reversed.equals(b)) {//뽑은게 폭발과 다르면
                    for (int j = 0; j < reversed.length(); j++) {
                        stack.push(reversed.charAt(j));
                    }

                }


            }
        }
        if (stack.size() == 0) {
            System.out.println("FRULA");
        } else {
            StringBuilder answer = new StringBuilder();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                answer.append(stack.pop());
            }
            System.out.println(answer.reverse().toString());
        }


    }
}
