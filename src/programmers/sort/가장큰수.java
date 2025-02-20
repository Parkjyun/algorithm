package programmers.sort;

import java.util.Arrays;

public class 가장큰수 {

    public String solution(int[] numbers) {
        //문자열로 변환해서 정렬하자.
        String[] arr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (a1, a2) -> {
            return (a2 + a1).compareTo(a1 + a2);
        });

        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(s);
        }
        String answer = sb.toString();
        if(answer.charAt(0) == '0' && answer.charAt(answer.length() - 1) == '0')
            return "0";
        return sb.toString();
    }
}
