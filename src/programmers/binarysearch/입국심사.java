package programmers.binarysearch;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long low = 0;
        long high = times[times.length - 1] * (long)n;//형변환 안 해주면 int*int -> 오버플로우 일어나고 long으로 들어감
        long passedPeopleCount = 0;
        long answer =0;

        while(low <= high) {
            long mid = low + (high-low)/2;
            passedPeopleCount = 0;
            for(int time : times) {
                passedPeopleCount += mid/time;
            }

            if (passedPeopleCount >= n) { // 모든 사람들이 심사를 받음 더 줄여도 돼
                high = mid - 1;
                answer = mid;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}
