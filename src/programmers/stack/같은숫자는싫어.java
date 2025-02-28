package programmers.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int num : arr) {
            if(stack.empty() || !stack.peek().equals(num)) {
                stack.push(num);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}

