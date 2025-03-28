package programmers.greedy;

import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int f = 0;
        int l = people.length - 1;

        while (f <= l) {
            if (people[f] + people[l] <= limit) {
                f++;
                l--;
            } else {
                l--;
            }

        }
        return answer;
    }
}
