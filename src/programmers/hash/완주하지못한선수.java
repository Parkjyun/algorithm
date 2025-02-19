package programmers.hash;

import java.util.*;

public class 완주하지못한선수 {

        public String solution(String[] participant, String[] completion) {
            //참여자가 aaa completion이 aa -> a가 retunr completion을 이름, 넘버
            // 참여자도 map으로 같은 키 비교 value 많다면 return
            Map<String, Integer> participantMap = new HashMap<>();

            //participant를 map으로
            for(int i = 0; i < participant.length; i++) {
                participantMap.put(participant[i], participantMap.getOrDefault(participant[i], 0) + 1);
            }

            for(int i = 0; i < completion.length; i++) {
                participantMap.put(completion[i], participantMap.get(completion[i]) - 1);
            }
            String answer = "";
            for(String key : participantMap.keySet()) {
                if (participantMap.get(key) == 1) {
                    answer = key;
                    break;
                }
            }
            return answer;
        }
}
