package programmers.implementation;

public class 이진변환반복하기 {
    int tCount = 0;
    int dCount = 0;
    public int[] solution(String s) {
        int[] answer = {};

        //1의 수를 샌다.
        // 그것을 이진법으로 나탄내다.
        // 결과가 1이될때까지 반복한다.
        transform(s);
        return new int[] {tCount, dCount};
    }
    //6 / 2 = 0    3 / 2  = 1  1 / 2  = 1

    String transform(String s) {
        int oCount = 0;
        if (s.equals("1")) return "1";
        tCount++;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) { // 1의 개수를 oCount로
            if (s.charAt(i) == '1') {
                oCount++;
            }
        }
        dCount += s.length() - oCount; //제거된 0의 개수를 더한다.

        while(oCount > 0) {
            sb.append(oCount %2);
            oCount /= 2;
        }


        System.out.println(sb.reverse().toString());
        return  transform(sb.reverse().toString());
    }
}
