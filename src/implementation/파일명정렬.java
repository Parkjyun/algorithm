package implementation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 파일명정렬 {
    public String[] solution(String[] files) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Arrays.sort(files, (s1, s2) -> {
            String h1 = s1.split("[0-9]")[0];
            String h2 = s2.split("[0-9]")[0];

            if(h1.compareToIgnoreCase(h2) == 0) {
                Matcher m1 = pattern.matcher(s1);
                m1.find();
                Matcher m2 = pattern.matcher(s2);
                m2.find();
                Integer num1 = Integer.parseInt(m1.group());
                Integer num2 = Integer.parseInt(m2.group());
                return num1.compareTo(num2);}
            else {
                return h1.compareToIgnoreCase(h2);
            }
        });
        return files;
    }
}