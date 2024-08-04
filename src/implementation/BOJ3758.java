package implementation;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ3758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int myId = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int tid = Integer.parseInt(st.nextToken());
                int pid = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                if (teams[tid-1] == null) {//만약 tid가 없다면 팀과 팀내의 scores 배열을 만든다.
                    teams[tid-1] = new Team();
                    teams[tid-1].teamId = tid;
                    teams[tid-1].scores = new int[k];
                }
                teams[tid-1].scores[pid-1] = Math.max(teams[tid-1].scores[pid-1], s);
                teams[tid-1].lastSumbit = j;
                teams[tid-1].submitCount++;
            }
            for (int j = 0; j < teams.length; j++) {
                for (int l = 0; l < teams[j].scores.length; l++) {
                    teams[j].score += teams[j].scores[l];
                }
            }
            //세팅 다됨
            Arrays.sort(teams, (o1, o2) -> {
                if (o1.score == o2.score) {
                    if(o1.submitCount == o2.submitCount) {
                        return o1.lastSumbit - o2.lastSumbit;
                    }
                    return o1.submitCount - o2.submitCount;
                }
                return o2.score - o1.score;
            });
            for (int j = 0; j < n; j++) {
                if (teams[j].teamId == myId) {
                    bw.append(String.valueOf(j+1)).append("\n");
                }

            }

        }
        bw.flush();
        bw.close();
    }
    static class Team {
        int teamId;
        int[] scores;
        int score;
        int submitCount;
        int lastSumbit;
        int rank;

    }
}
