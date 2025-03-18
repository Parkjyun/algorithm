package programmers.bruteforce;

public class 숫자의표현 {
    public int solution(int n) {
        int[] arr = new int[n+1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int sum;
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i+1; j < arr.length; j++) {
                sum += arr[j];
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }

        return answer;
    }
}
