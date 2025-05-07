package programmers.implementation;

public class n진수게임 {
    public String solution(int n, int t, int m, int p) {
        //n진법으로 표현한 문자열 을 length = t*m
        // index : p-1 + m*i(i :0 ~ t-1)까지

        StringBuilder sb = new StringBuilder();

        int num = 0;
        while (sb.length() <= t * m -1) {
            sb.append(tenToN(num, n));
            //end
            num++;
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < t; i++) {
            answer.append(sb.substring(p-1 + m*i, p + m*i));
        }
        return answer.toString();
    }

    String tenToN(int num, int n) {
        //num을 n진법으로 변경한다.
        StringBuilder sb = new StringBuilder();
        if(num == 0) return "0";

        while(num > 0) {
            int add = num % n;
            num/=n;

            if (add >= 10) {
                if (add == 10) sb.insert(0, "A");
                if (add == 11) sb.insert(0, "B");
                if (add == 12) sb.insert(0, "C");
                if (add == 13) sb.insert(0, "D");
                if (add == 14) sb.insert(0, "E");
                if (add == 15) sb.insert(0, "F");
            } else {
                sb.insert(0, String.valueOf(add));
            }

        }
        return sb.toString();
    }
}
