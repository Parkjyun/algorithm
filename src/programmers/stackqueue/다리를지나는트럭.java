package programmers.stackqueue;

import java.util.*;

public class 다리를지나는트럭 {
    Queue<int[]> q = new LinkedList<>();
    //int -> 무게, 남은 시간
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        int index = 0;
        while(true) {
            time++;
            for(int[] e : q) {
                e[1]--;
            }
            if(!q.isEmpty() && q.peek()[1] == 0) {
                q.poll();
            }
            if(index < truck_weights.length && available(bridge_length, weight, truck_weights[index])) {//현재 큐에 새로운 것 넣을 수 있는지 by 개수, 무게
                q.offer(new int[] {truck_weights[index++], bridge_length});
            }
            if (index == truck_weights.length && q.isEmpty()) break;
        }
        return time;
    }
    //무게, 대수 가능한지
    boolean available(int bridge_length, int weight, int nw) {
        int sum = 0;
        for (int[] e : q) {
            sum += e[0];
        }
        return sum + nw <= weight && q.size() < bridge_length;

    }
}
