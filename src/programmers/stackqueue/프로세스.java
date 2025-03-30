package programmers.stackqueue;

import java.util.*;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Point(i, priorities[i]));
        }
        int count = 0;
        while(!q.isEmpty()) {//q가 비지 않았다면
            int mp = Integer.MIN_VALUE;
            for (Point p : q) {
                mp = Math.max(mp, p.priority);
            }

            Point point;
            while (true) {
                point = q.poll();

                if (point.priority == mp) {
                    count++;
                    break;
                } else {
                    q.offer(point);

                }
            }
            if (point.order == location && point.priority == mp) {
                answer = count;
                break;
            }
        }

        return answer;

        //몇번째로 실행되는지 123
        // 1. 빼기 전에 한번 돌면서 최대 priority검색
        // 2. mp 많나면 poll, count++  아니면 다시 offer
        // 3. val, point 같으면 offer
        // 4. location == order -> boom!
    }

    class Point {
        int order; // == location
        int priority;

        Point(int order, int priority) {
            this.order = order;
            this.priority = priority;
        }
    }
}
