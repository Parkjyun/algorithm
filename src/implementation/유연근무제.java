package implementation;

public class 유연근무제 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < timelogs.length; i++) { // 각각의 사람에 대해
            int d = startday % 7;
            int count = 0;
            for (int j = 0; j < timelogs[i].length; j++) { // 한 사람 시간에 대해
                if (tom(timelogs[i][j]) <= tom(schedules[i]) + 10 || d == 6 || d == 0) { // 시간 내 or 주말
                    count++;
                }
                d = (d+1)%7; // 다음!!
            }
            if (count == timelogs[i].length) {
                answer++;
            }
        }
        return answer;
    }

    int tom (int n) {

        return (n/100) * 60 + n % 100;
    }
}
