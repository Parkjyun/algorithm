package programmers.implementation;

import java.util.*;

public class 압축 {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int counter;
        for (counter = 1 ; counter < 27; counter++) {
            map.put(String.valueOf((char)(counter+64)), counter);
        }
        while (msg.length() != 0) {

            for (int i = msg.length(); i > 0; i--) {
                String w = msg.substring(0,i);
                if (map.keySet().contains(w)) { // 가장 긴 문자열부터찾아
                    //최초 true 시 최대 길이임
                    list.add(map.get(w)); // w에 해당하는 것 출략
                    msg = msg.substring(i, msg.length());
                    if(msg.length() > 0) {
                        map.put(w + msg.substring(0,1), counter++);
                    }
                    break;
                }
            }

        }

        return list.stream().mapToInt(i -> i).toArray();
    }

}

