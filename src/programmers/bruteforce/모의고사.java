package programmers.bruteforce;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] pattern1 = {1,2,3,4,5};
        int[] pattern2 = {2,1,2,3,2,4,2,5};
        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5};

        int a = 0;
        int b = 0;
        int c = 0;

        for(int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i%pattern1.length]) a++;
            if (answers[i] == pattern2[i%pattern2.length]) b++;
            if (answers[i] == pattern3[i%pattern3.length]) c++;
        }
        List<Integer> results = new ArrayList<>();
        int max = Math.max(a, Math.max(b, c));
        if (a == max) {
            results.add(1);
        }
        if (b == max) {
            results.add(2);
        }
        if (c == max) {
            results.add(3);
        }
        Collections.sort(results);
        return results.stream().mapToInt(i->i).toArray();
    }
}
