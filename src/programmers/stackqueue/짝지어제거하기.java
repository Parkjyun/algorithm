package programmers.stackqueue;

import java.util.*;

public class 짝지어제거하기 {
    public int solution(String s)
    {
        int answer = 0;

        Deque<Character> stack = new ArrayDeque<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (stack.peek() != null && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            answer = 1;
        }
        return answer;
    }
}
