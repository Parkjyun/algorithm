package programmers.implementation;

import java.util.*;

public class 성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        /*
        survey = rt, tr -> cj 처음은 비동의 시 받게 되는 점수
        choices는 1 매우 비동의 7은 매우 동의를 의미
        1. map으로 type, 점수 만들어 둠
        2. survey돌면서 choice비교해서 각각의 map에 점수를 준다.
        3. 다 돌구 answer 생성
        */
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            if (choices[i] > 4) {
                map.put(s.substring(1,2), map.getOrDefault(s.substring(1,2), 0) + choices[i] - 4);
            } else if (choices[i] < 4) {
                map.put(s.substring(0,1), map.getOrDefault(s.substring(0,1), 0) + 4 - choices[i]);
            }
        }

        if (map.getOrDefault("R",0) >= map.getOrDefault("T", 0)) {
            answer += "R";
        } else {
            answer += "T";
        }
        if (map.getOrDefault("C", 0) >= map.getOrDefault("F",0)) {
            answer += "C";
        } else {
            answer += "F";
        }
        if (map.getOrDefault("J", 0) >= map.getOrDefault("M", 0)) {
            answer += "J";
        } else {
            answer += "M";
        }
        if (map.getOrDefault("A",0) >= map.getOrDefault("N",0)) {
            answer += "A";
        } else {
            answer += "N";
        }

        return answer;
    }
}
