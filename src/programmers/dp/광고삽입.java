package programmers.dp;

class 광고삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        //가장 많이 보는 구간에 광고
        if (play_time.equals(adv_time)) return "00:00:00";
        int total = tos(play_time);
        long[] cs = new long[total + 1]; // 0은 그냥 버릴게요 -> 0 1 2 3
        long[] diff = new long[total + 1];
        long[] csb = new long[total + 1];
        for (int i = 0; i < logs.length; i++) { // 30만
            String l = logs[i];
            String[] temp = l.split("-");

            int s = tos(temp[0]);
            int e = tos(temp[1]);
            diff[s]++; // 2초
            diff[e]--; // 5초
        }
        csb[0] = diff[0];
        for (int i = 1; i < diff.length; i++) { // 30만
            csb[i] = csb[i-1] + diff[i];
        }
        //cs[i]는 i초까지 누적으로 본 사람 수 만약 10이라면 // 0 - 10

        for (int i = 1; i < diff.length; i++) { // 30만
            cs[i] = cs[i-1] + csb[i-1];
        }

        long max = Integer.MIN_VALUE;
        int range = tos(adv_time);
        int answer = 0;
        for (int i = 0; i < cs.length - range; i++) {
            if (cs[i+ range] - cs[i] > max) {
                answer = i;
                max = cs[i+ range] - cs[i];
            }
        }

        return toString(answer);
    }
    String toString(int t) {
        StringBuilder sb = new StringBuilder();
        int r = t / 3600;
        if (r < 10) {
            sb.append(0).append(r);
        } else {
            sb.append(r);
        }

        sb.append(":");
        t = t % 3600;
        r = t / 60;
        if (r < 10) {
            sb.append(0).append(r);
        } else {
            sb.append(r);
        }

        sb.append(":");
        t = t % 60;

        if (t < 10) {
            sb.append(0).append(t);
        } else {
            sb.append(t);
        }
        return sb.toString();
    }

    int tos(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 3600 + Integer.parseInt(arr[1]) * 60 + Integer.parseInt(arr[2]);
    }
}