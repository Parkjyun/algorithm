package programmers.greedy;

public class 택배배달과수거 {
    int dCursor;
    int pCursor;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        dCursor = deliveries.length;
        pCursor = pickups.length;//2
        while (dCursor > 0 || pCursor > 0) { //dc & pc 둘다 1이상일때만

            while (dCursor > 0 && deliveries[dCursor-1] == 0) {
                dCursor--;
            }
            while (pCursor > 0 && pickups[pCursor-1] == 0) {
                pCursor--;
            }

            //커서 다 줄였다.
            answer = answer + (Math.max(dCursor, pCursor)) * 2L;

            //4개씩 줄이자.
            decrease(cap, dCursor, deliveries);//pcursor-1부터 cap개 빼가자~
            decrease(cap, pCursor, pickups);


        }
        return answer;
    }

    void decrease(int cap, int cursor, int[] list) {
        for (int i = cursor - 1; i >= 0; i--) {
            if (cap > list[i]) {
                cap -= list[i];
                list[i] = 0;
            } else if (cap == list[i]) {
                list[i] = 0;
                break;
            } else if (cap < list[i]) {
                list[i] -= cap;
                break;
            }
        }
    }
}
