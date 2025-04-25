package programmers.stackqueue;

import java.util.*;

public class 괄호변환 {
    public String solution(String p) {
        return first(p);


    }
    String first(String w) {
        //1
        if (w.isEmpty()) return "";
        //2
        int l = 0;
        int r = 0;
        String u="";
        String v="";
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                u = w.substring(0, i+1);
                v = w.substring(i+1, w.length());
                break;
            }

        }
        //3
        if(isRight(u)) {
            return u + first(v);
        } else {
            String temp = "(";
            temp += first(v) + ")";
            String bu = u.substring(1, u.length()-1);
            for (int i = 0; i < bu.length(); i++) {
                if (bu.charAt(i) == '(') {
                    temp += ")";
                } else {
                    temp += "(";
                }
            }
            return temp;
        }

    }

    boolean isRight(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else { // )
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
