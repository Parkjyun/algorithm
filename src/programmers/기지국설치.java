package programmers;

public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int start = 1;
        int answer = 0;
        int end = n;
        int size = 2 * w + 1;
        for (int i = 0; i < stations.length; i++) {
            if (stations[i] - w - 1 >= 1) {
                end = stations[i] - w - 1;
            } else {
                end = 0;
            }
            if (end >= start) {
                answer += Math.ceil((end - start + 1) / size);
                if ((end - start + 1) % size != 0)
                    answer++;
            }

            if (stations[i] + w + 1 <= n) {
                start = stations[i] + w + 1;
            } else {
                start = n + 1;
            }
        }

        if (stations[stations.length - 1] + w < n) {
            answer += Math.ceil((n - start + 1) / size);
            if ((n - start + 1) % size != 0)
                answer++;
        }
        return answer;
    }
}
