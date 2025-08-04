package programmers.implementation;

public class 퍼즐게임챌린지 {
    public int solution(int[] diffs, int[] times, long limit) {

        int l = 1;
        int h = 100000;
        while (l < h) {

            int m = (l + h)/2;

            if (solveTime(m, diffs, times) > limit) {
                l= m + 1;
            } else {
                h=m;
            }

        }
        return h;

    }

    private long solveTime(int level, int[] diffs, int[] times) {
        long time = 0;
        for (int i = 0; i < times.length; i++) {
            if (i >= 1) {
                if (diffs[i] - level >= 0) {
                    time += (diffs[i] - level) * (times[i] + times[i-1]) + times[i];
                } else {
                    time += times[i];
                }

            } else {
                if (diffs[i] - level >= 0) {
                    time += (diffs[i] - level) * times[i] + times[i];
                } else {
                    time += times[i];
                }
            }
        }
        return time;
    }
}
