package programmers.implementation;

import java.util.*;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        StringTokenizer st;
        Map<String, String> map = new HashMap<>();
        int size = 0;
        for (String s : record) {
            st = new StringTokenizer(s);
            String command = st.nextToken();
            String key = st.nextToken();

            if (command.equals("Enter")) {
                String value = st.nextToken();
                map.put(key, value);
                size++;
            } else if (command.equals("Leave")) {
                size++;
            } else if (command.equals("Change")) {
                String value = st.nextToken();
                map.put(key, value);
            }
        }

        String[] answer = new String[size];
        int index = 0;
        for (String s : record) {
            st = new StringTokenizer(s);
            String command = st.nextToken();
            String key = st.nextToken();
            if (command.equals("Enter")) {
                answer[index] = map.get(key) + "님이 들어왔습니다.";
                index++;
            } else if (command.equals("Leave")) {
                answer[index] = map.get(key) + "님이 나갔습니다.";
                index++;
            }

        }
        return answer;
    }
}
