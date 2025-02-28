package programmers.stackqueue;

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

