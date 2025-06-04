package programmers.implementation;

import java.util.*;

public class 셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < timetable.length; i++) {
            list.add(toMin(timetable[i]));
        }
        Collections.sort(list);

        for (int i = 0; i < n -1; i++) { // 매회마다
            int time = toMin("9:00") + i*t; // 출발시간
            int count = m;
            while(count-- > 0) { // 버스 인원만틈
                if (!list.isEmpty()) { // 대기열에 사람이 있고
                    if (list.get(0) <= time) { // 태울 수 있다.
                        list.remove(0);
                    } else {
                        break; // -> 다음버스
                    }
                }
            }
        }


        int time = toMin("9:00") + t * (n-1); // 마지막출발시간
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < Math.min(m, list.size()); i++) { // m명 돌면서
            if(list.get(i) <= time) {
                max = Math.max(max, list.get(i));
                count++;
            } else {
                break;
            }
        }

        int answer = 0;
        if (count == m) { //full
            answer = max -1;
        } else {
            answer = time;
        }

        int h = answer/60;
        String sh = String.valueOf(h);
        int mm = answer%60;
        String sm = String.valueOf(mm);
        if (h < 10) {
            sh = "0" + sh;
        }
        if (mm < 10) {
            sm = "0" + sm;
        }
        return sh + ":" + sm;

    }

    int toMin(String s) {
        String[] ts = s.split(":");
        return Integer.parseInt(ts[0]) * 60 + Integer.parseInt(ts[1]);

    }
}
