package programmers.heap;

import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        //cf. remove는 특정 원소(삽입한 것이랑 같은 넘을 삭제한다.~)
        // 최소힙과 최대 힙을 사용하는 우선순위큐를 만든다.
        PriorityQueue<Integer> q = new PriorityQueue<>();//poll시 가장 작은 것
        PriorityQueue<Integer> reverseQ = new PriorityQueue<>((o1, o2) -> o2-o1);//poll시 가장 큰 것

        //명령어에따라 다음 동작을 수행한다.
        for(String operation : operations) {
            char operator = operation.charAt(0);

            if(operator == 'I') {
                int number = Integer.parseInt(operation.substring(2, operation.length()));
                q.offer(number);
                reverseQ.offer(number);

            } else if (operator == 'D') {
                int number = Integer.parseInt(operation.substring(2, operation.length()));
                if (number < 0) { //큐에서 최솟값을 삭제
                    if (!q.isEmpty()) {
                        int num = q.poll();
                        reverseQ.remove(num);
                    }
                } else { //큐에서 최대값을 삭제
                    if (!q.isEmpty()) {
                        int num = reverseQ.poll();
                        q.remove(num);
                    }

                }
            }
        }
        return (q.isEmpty()) ? new int[]{0,0} : new int[]{reverseQ.poll(), q.poll()};
    }
}
