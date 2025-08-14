package programmers.implementation;

public class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        long answer = 0;
        int mul = 1;


        for (int i = 0; i < sequence.length; i++) {
            sequence[i] *= mul;
            mul *= -1;
        }

        long max = sequence[0];
        long sum = sequence[0];
        for (int i = 1; i < sequence.length; i++) {
            sum = Math.max(sum+sequence[i], sequence[i]);
            max = Math.max(max, sum);
        }


        for (int i = 0; i < sequence.length; i++) {
            sequence[i] *= -1;

        }
        sum = sequence[0];
        max = Math.max(max, sum);
        for (int i = 1; i < sequence.length; i++) {
            sum = Math.max(sum+sequence[i], sequence[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
