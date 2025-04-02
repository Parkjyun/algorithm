package programmers.implementation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 튜플 {
    public int[] solution(String s) {


        String arr[] = s.substring(2, s.length()-2).split("\\},\\{");
        int[] answer = new int[arr.length];

        Arrays.sort(arr, (a, b) -> a.length() - b.length()); //arr 은 2   2,1     2,1,4

        Set<String> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            String[] numarr = str.split(",");
            for (int j = 0; j < numarr.length; j++) {
                if (!set.contains(numarr[j])) {
                    set.add(numarr[j]);
                    answer[i] = Integer.parseInt(numarr[j]);
                    break;
                }
            }

        }
        return answer;
    }
}
