package programmers.greedy;

import java.util.*;

public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 1;
        //route의 [1]을 기준으로 오름차순 정렬;

        Arrays.sort(routes, (a,b) -> a[1] - b[1]);

        int last = routes[0][1];

        for(int i = 1; i < routes.length; i++) {
            if (routes[i][0] <= last) {
                continue;
            } else {
                answer++;
                last = routes[i][1];
            }
        }

        return answer;
    }
}
