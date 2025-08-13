package programmers.implementation;

public class 최고의집합 {
    public int[] solution(int n, int s) {

        //n개로 합이 s
        // n은 3 s는 8
        // 1 1 6
        // 1 2 5
        // 1 3 4
        // 2 2 4
        // 2 3 3
        if (n > s) return new int[] {-1};
        int answer[] = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = s/n;
        }
        for (int i = 0; i < s%n; i++) {
            answer[answer.length-i-1]++;
        }

        return answer;
    }
}
