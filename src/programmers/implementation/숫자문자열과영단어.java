package programmers.implementation;

import java.util.*;

public class 숫자문자열과영단어  {
    public int solution(String s) {

        StringBuilder sb = new StringBuilder();
        String[] arr = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        List<String> list = List.of(arr);

        for(int i = 1; i <= s.length(); i++) {
            if(s.substring(0,i).matches("[0-9]")) {
                sb.append(s.substring(0,i));
                s = s.substring(i, s.length());
                i = 0;
            } else {
                if(list.contains(s.substring(0,i))) {
                    for (int j = 0; j < 10; j++) {
                        if (list.get(j).equals(s.substring(0,i))) {
                            sb.append(j);
                            s = s.substring(i, s.length());
                            i = 0;
                            break;
                        }
                    }
                }
            }
        }
        return Integer.parseInt(sb.toString());
    }
}