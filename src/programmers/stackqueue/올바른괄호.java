package programmers.stackqueue;

import java.util.*;

public class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        int right = 0;
        while(!stack.isEmpty()) {
            int c = stack.pop();
            if(c == ')') right++;
            else {
                right--;
            }
            if (right < 0) return false;
        }
        if (right == 0) return true;
        return false;


    }
}
