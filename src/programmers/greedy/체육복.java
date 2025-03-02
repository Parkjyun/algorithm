package programmers.greedy;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }
        for (int i = 0; i < lost.length; i++) {
            arr[lost[i]-1]--;
        }
        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i]-1]++;
        }

        for (int i = 0; i < n; i++) {//나눠주는 것을 전체로 한다.
            if (0 <i && i < n - 1) { // 중간
                if (arr[i] == 2) {
                    if (arr[i - 1] == 0) {
                        arr[i - 1]++;
                        arr[i]--;
                        continue;
                    }
                    if (arr[i + 1] == 0) {
                        arr[i + 1]++;
                        arr[i]--;
                    }
                }
            }
            else if(i == n-1) {//맨마지막
                if (arr[i] == 2) {//2개라면
                    if (arr[i - 1] == 0) {
                        arr[i - 1]++;
                        arr[i]--;
                    }
                }
            }
            else if(i == 0) { //처음
                if (arr[i] == 2) {
                    if (arr[i + 1] == 0) {
                        arr[i + 1]++;
                        arr[i]--;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(arr[i] == 1 || arr[i] == 2) answer++;
        }
        return answer;
    }
}
