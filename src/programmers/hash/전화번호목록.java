package programmers.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for(String str : phone_book) {
            for(int i = 1; i < str.length(); i++) {
                if(set.contains(str.substring(0,i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
