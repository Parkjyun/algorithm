package programmers.implementation;

import java.util.*;

public class 방금그곡 {
    class M {
        int t; // 1 감소순
        String f;
        String name;
        int order;

        M(int t, String f, String name, int order) {
            this.t = t;
            this.f = f;
            this.name = name;
            this.order = order;
        }
    }
    public String solution(String m, String[] musicinfos) {
        m = m.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g").replaceAll("A#", "a").replaceAll("B#", "b");
        M[] ms = new M[musicinfos.length];

        for (int i = 0; i < musicinfos.length; i++) {
            String[] s = musicinfos[i].split(",");
            String st = s[0];
            String et = s[1];
            String[] sts = st.split(":");
            String[] ets = et.split(":");
            int min = 60 * (Integer.parseInt(ets[0]) - Integer.parseInt(sts[0])) + Integer.parseInt(ets[1]) - Integer.parseInt(sts[1]);
            String name = s[2];
            String scale = s[3].replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g").replaceAll("A#", "a").replaceAll("B#", "b");
            int t = min / scale.length();
            int sp = min % scale.length();

            StringBuilder fullscale = new StringBuilder();
            for (int j = 0; j < t; j++) {
                fullscale.append(scale);
            }
            fullscale.append(scale.substring(0, sp));
            System.out.println(fullscale);

            ms[i] = new M(min, fullscale.toString(), name, i);

        }
        //t 감소순 h증가순 m증가순
        Arrays.sort(ms, (a,b) -> {
            if(b.t == a.t) {
                return a.order - b.order;
            } else {
                return b.t - a.t;
            }

        });
        String answer = "(None)";
        for (int i = 0; i < ms.length; i++) {
            if (ms[i].f.contains(m)) {
                answer = ms[i].name;
                break;
            }
        }
        return answer;
    }
}
