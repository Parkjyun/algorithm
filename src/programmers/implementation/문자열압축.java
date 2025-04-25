package programmers.implementation;

public class 문자열압축  {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if (s.length()==1) return 1;

        for (int i = 1; i <= s.length()/2; i++) { //단위
            int count = 0;
            String before = s.substring(0,i);
            String temp = "";
            int index = 0;
            while(index <= s.length() - i) {
                String section = s.substring(index, index + i);
                if (section.equals(before)) {
                    count++;
                } else { //다르다면
                    if (count ==1) {
                        temp +=before;
                    } else {
                        temp += count;
                        temp +=before;
                    }

                    before = section;
                    count = 1;
                }

                index += i;
            }
            //나머지들 더하는 것
            if (count ==1) {
                temp +=before;
            } else {
                temp += count;
                temp +=before;
            }

            temp += s.substring(index, s.length());
            answer = Math.min(temp.length(), answer);
        }

        return answer;
    }
}
