package programmers.stackqueue;

import java.util.*;

public class 괄호회전하기 {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String turned = turn(s, i);
            if (isRight(turned)) {
                answer++;
            }
        }

        return answer;
    }

    String turn(String s, int n) { //s를 i만큼 왼쪽으로 0이면 그대로 1이면 한칸씩 왼쪽으로
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt((i+n) % s.length());
        }
        return String.valueOf(arr);

    }

    boolean isRight(String s) {
        char[] arr = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        boolean result = true;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else { // 닫는 애들이라면
                if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        result = false;
                        break;
                    }
                }
                if (c == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        result = false;
                        break;
                    }
                }
                if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        result = false;
                        break;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            result = false;
        }
        return result;
    }
}
