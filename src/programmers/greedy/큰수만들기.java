package programmers.greedy;

public class 큰수만들기 {
    public String solution(String number, int k) {//k개의 수를 제거
        StringBuilder answer= new StringBuilder();

        int idx = 0;
        int max;

        //뽑는 것 기준으로 ㄱ ㄱ
        for (int i = 0; i < number.length() - k; i++) { // 총 n - k만큼의 select를 시전
            max = 0;
            for(int j = idx; j < i + k + 1; j++) {//index는 max이후 다음
                if (max < number.charAt(j) - '0') {//max라면
                    max = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
