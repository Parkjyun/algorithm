package programmers.stackqueue;

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            int leftDays;
            if ((100 - progresses[i]) % speeds[i] == 0) { //나누어 떨어지면
                leftDays = (100 - progresses[i]) / speeds[i];
            } else {
                leftDays = (100 - progresses[i]) / speeds[i] + 1;
            }
            q.offer(leftDays);
        }

        for (int n : q) {
            System.out.println(n);
        }

        while(!q.isEmpty()) {
            int first = q.poll();
            if(q.peek() == null) {
                list.add(1);
                break;
            }
            if(first < q.peek()) {
                list.add(1);
            } else { // 앞이 크다면 == 뒤에 작업들이 끝났다면
                int count = 1;
                while(first >= q.peek()) {
                    q.poll();
                    count++;
                    if(q.peek() == null) {

                        break;
                    }

                }
                list.add(count);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
