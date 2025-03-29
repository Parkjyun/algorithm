package programmers.bruteforce;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        Set<String> taken = new HashSet<>();

        int[] answer = new int[2];
        for (int i = 0; i < words.length; i++) {
            if (taken.contains(words[i])) { // 중복
                int firstFail = ((i+1)%n) == 0 ? n : (i+1)%n;
                answer = new int[] {firstFail, i/n+1};
                break;
            }
            if (i >= 1 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) ) { // 틀린말
                int firstFail = ((i+1)%n) == 0 ? n : (i+1)%n;
                answer = new int[] {firstFail, i/n+1};
                break;
            }
            taken.add(words[i]);
        }


        return answer;
    }
}
