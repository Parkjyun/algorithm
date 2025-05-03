package programmers.stackqueue;

import java.util.*;

public class 주식가격 {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >prices[i]) {
                int pop = stack.pop();
                answer[pop] = i - pop;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int pop = stack.pop();
            answer[pop] = prices.length - 1 - pop;
        }
        return answer;
    }
}
