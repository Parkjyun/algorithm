package programmers.bruteforce;

public class 다음큰숫자 {
    public int solution(int n) {
        int count = getCount(n);
        int answer = 0;

        while(true) {
            n++;
            int nc = getCount(n);
            if (count == nc) {
                answer = n;
                break;
            }
        }
        return answer;
    }

    int getCount(int n) {
        int count = 0;
        while(n >= 1) {
            if (n % 2 == 1) count++;
            n = n / 2;
        }
        return count;
    }
}
