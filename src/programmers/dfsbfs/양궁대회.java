package programmers.dfsbfs;

import java.util.*;

public class 양궁대회 {
    static int[] b = new int[11];
    static int max = Integer.MIN_VALUE;
    static int[] maxa;
    public int[] solution(int n, int[] info) {//n은 화살의 개수 = 10 info 10 - 0
        //어피치가 먼저 화살쏜다
        // 같은 숫자에 대해 a >= r 인 경우 어피치가 나머지는 라이언
        //라이언은 최대 점수차로 이겨야함 -> 10점부터 0저맊지 몇발씩??
        //info에는 10점부터 0점까지

        //라이언이 가장 큰 점수차로 이길 확률은?
        //여러 가지 일 경우 가장 낮은 점수를 더 많이 맞힌 경우
        //[-1] return 어떻게 해도 이기지 못할 경우

        int[] answer = {};

        brian(0,10, info, n);
        if (maxa == null) {
            return new int[] {-1};
        } else {
            return maxa;
        }

    }

    void brian(int depth, int start, int[] info, int n) {
        if (depth == n) {
            if (calculate(info, b)) {
                maxa = Arrays.copyOf(b, b.length);
            }
            return;
        }

        for (int i = start; i >= 0; i--) { // 0 - 10
            b[i]++;
            brian(depth+1, i, info, n);
            b[i]--;
        }
    }
    boolean calculate(int[] info, int[] ba) {
        int b = 0;
        int a = 0;
        for (int i = 0; i < info.length; i++) {
            if(info[i] == 0 && ba[i] == 0) continue;
            if (info[i] >= ba[i] ) {
                a += 10-i;
            } else {
                b += 10 -i;
            }


        }
        if (b > a) { //라이언이 이길 경우
            if (b-a > max) { //최대 점수차이라면
                max = b-a;
                return true;
            }
        }
        return false;
    }
}
