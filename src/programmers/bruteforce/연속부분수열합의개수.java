package programmers.bruteforce;

import java.util.*;
public class 연속부분수열합의개수 {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++ ) {
                int sum = 0;
                for (int a = j; a < j+i; a++) {
                    sum+= elements[(a) % elements.length];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}
