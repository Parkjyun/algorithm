package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        //priorityqueue 우선순위 같다면 fifo임
        //작업 소요시간이 짧은 것, 작업의 요청시각이 빠른 것, 작업의 번호가 작은 것 순으로
        //1.은 pq의 정렬 기준, 2. 우선순위 same시에 어차피 fifio인데 jobs가 요청시각 순으로 이미 정렬 -> 충족
        // 작업의 소요시간 갖고 작업의 요청시각이 같다. -> 작업의 번호가 작은 것 순으로 <- 사실 필요 없는 조건, 12같다면 답인 반환시간에 영향 미치지 않는다.

        //우선순위 == 소요시간 짧은 것
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {return o1[1]-o2[1];});
        //요청시간 오름차순
        Arrays.sort(jobs, (o1, o2) -> {return o1[0] - o2[0];});
        int endTime = 0;
        int index = 0;
        int answer = 0;
        int count = 0;

        while(count < jobs.length) {//모든 job에 대해
            while(index < jobs.length && jobs[index][0] <= endTime) {//다음 잡의 시작시간이
                q.offer(jobs[index++]);
            }
            //큐가 비어있다 -> end이후에 요청이 들어온다.
            if(q.isEmpty()) {
                endTime = jobs[index][0];
            } else { //큐가 비어있지 않다면 일 하나 수행하고 다시 큐에 넣으로 가자~~
                int[] poll = q.poll();
                endTime += poll[1];
                answer += (endTime - poll[0]);
                count++;
            }
        }
        return answer/jobs.length;
    }
}
