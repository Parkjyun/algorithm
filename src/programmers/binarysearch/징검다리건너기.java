package programmers.binarysearch;

public class 징검다리건너기 {
    public int solution(int[] stones, int k) {
        //열린 구간으로 하면
        // l < h
        // possible -> l = m+1;
        // !possible -> h = m;
        // return l-1;

        //닫힌 구간 이분탐색 풀이.
        int l = 1;
        int h = 200000000;
        int m = 0;
        int answer = 1;

        while (l <= h) {
            m = l + (h-l)/2;
            int zc = 0;
            boolean possible = true;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] <= m-1) {// m-1명 지났을 때 0이 되는 곳
                    zc++;
                    if (zc == k) {//m-1 끝 난 후 연속적으로 새서  k개라면
                        possible = false; //m 건너기 불가
                        break;
                    }
                } else {
                    zc = 0;
                }
            }
            if (possible) {// m명 가능
                answer = m;
                l = m+1;
            } else {
                h = m-1;
            }
        }
        return answer;
    }
}
