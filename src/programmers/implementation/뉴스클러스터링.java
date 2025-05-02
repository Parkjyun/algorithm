package programmers.implementation;

import java.util.*;

public class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String ls = str1.substring(i, i+2).toLowerCase();
            if (check(ls.charAt(0)) && check(ls.charAt(1))) {
                list1.add(ls);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String ls = str2.substring(i, i+2).toLowerCase();
            if (check(ls.charAt(0)) && check(ls.charAt(1))) {
                list2.add(ls);
            }
        }

        int sa = list1.size();
        int sb = list2.size();

        List<String> intersect = new ArrayList<>();
        for (String a : list1) { // a돌면서
            if (list2.remove(a)) {//b에 a가 있다먄
                intersect.add(a);
            }
        }

        double answer = (double)intersect.size()/(sa + sb - intersect.size());
        if (sa == 0 && sb == 0) {
            answer = 1;

        }
        return (int)Math.floor(answer * 65536);
    }

    boolean check(char c) {
        if ('a' <= c && c <= 'z') return true;
        return false;
    }
}
