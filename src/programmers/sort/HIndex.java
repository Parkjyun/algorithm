package programmers.sort;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); //오름차순 정렬;
        for (int i = 0; i < citations.length; i++) {//1부터 마지막숫자까지 돌면서
            //논문 인용 횟수가 인덱스보다 커지면 (모든 논문 개수 - 해당)
            int h = citations.length - i; // 인용수
            if(citations[i] >= h ) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
