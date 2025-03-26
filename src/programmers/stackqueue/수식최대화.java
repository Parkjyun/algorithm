package programmers.stackqueue;

import java.util.*;
import java.lang.*;

public class 수식최대화 {
    long answer = Long.MIN_VALUE;
    int[] priority = new int[3];//+-*, index가 priority
    boolean[] visited = new boolean[3];//+-*
    List<Long> opperands = new LinkedList<>();
    List<String> operators = new LinkedList<>();

    public long solution(String expression) {

        dfs(0, expression);
        return answer;
    }
    //dfs로 우선순위를 정하는
    //중위식을 후쉬식으로 변환하는 -> 자기보다 우선순위 큰놈이 이미 stack에 있다면 빼버린다.
    //문자열로 후위식이 주어지면 계산하는 abc*+ stack에 하나씩 넣으면서 연산자면 계산

    void dfs(int depth, String expression) {
        if (depth == 3) {//해당 우선순위 경우 대해
            //후위식으로 변환하고
            // calculatePost(List.of("50", "6", "*", "3", "2", "*", "-"));
            calculatePost(toPost(expression));//후위식을 계산한다.

        }

        for(int i = 0; i < 3; i++) {// 012 -> 021 ... 이경우 값이자 인덱스 012 -> * - + 순서
            if (!visited[i]) {
                visited[i] = true;
                priority[depth] = i;
                dfs(depth+1, expression);
                priority[depth] = 0;
                visited[i] = false;
            }
        }



    }

    List<String> toPost(String s) {//숫자면 append. 수면 stack으로 나보다 우선순위 낮은놈만 깔아 뭉갤 수 있음
        Deque<String> stack = new ArrayDeque<>();
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, "[\\*+-]", true);
        while(st.hasMoreTokens()) {
            String token = st.nextToken();

            if ((isOperator(token))) { //연산자라면
                while(!stack.isEmpty()) {
                    String operator = stack.peek();
                    if (getPriority(operator) >= getPriority(token)) { //기존게 우선순위 높다면 또는 같은 것 먼저 들어왔다면
                        res.add(stack.pop()); // 빼고
                    } else {
                        break; //기존것이 우선순위 작다면 연산자 빼는 것 멈추고
                    }
                }
                stack.push(token);



            } else { //연산자가 아니라면
                res.add(token);
            }
        }

        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }


        return res;
    }

    int getPriority(String operator) {
        if (operator.equals("+")) {
            return priority[0];
        } else if (operator.equals("-")) {
            return priority[1];
        } else {
            return priority[2];
        }
    }

    void calculatePost(List<String> res) {  //후위식이 들어온다
        // String[] arr = s.split("[\\*+-]");
        Deque<Long> stack = new ArrayDeque<>();

        for (String token : res) {

            if ((isOperator(token))) { //연산자라면
                long second = stack.pop();
                long first = stack.pop();
                if (token.equals("+") ) {
                    stack.push(first + second);
                } else if (token.equals("-")) {
                    stack.push(first - second);
                } else {
                    stack.push(first * second);
                }
            } else { //연산자가 아니라면
                stack.push(Long.parseLong(token));
            }
        }
        long can = Math.abs(stack.pop());

        answer = Math.max(answer, can);
    }

    boolean isOperator(String s) {
        if (s.equals("+")  || s.equals("*") || s.equals("-")) {
            return true;
        } else {
            return false;
        }
    }
}
