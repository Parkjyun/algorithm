package programmers.implementation;

import java.util.*;

public class 가장많이받은선물 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] arr = new int[friends.length];
        int[][] map = new int[friends.length][friends.length];

        Map<String, Integer> index = new HashMap<>();

        int ii = 0;
        for (String f : friends) {
            index.put(f, ii);
            ii++;
        }

        for (int i = 0; i < gifts.length; i++) {
            StringTokenizer st = new StringTokenizer(gifts[i]);
            String from = st.nextToken();
            String to = st.nextToken();

            int a = index.get(from);
            int b = index.get(to);

            map[a][b]++;
        }

        Map<Integer, Integer> point = new HashMap();
        for (int i = 0; i < map.length; i++) {

            for(int j = 0; j < map.length; j++) {
                point.put(i, point.getOrDefault(i, 0) + map[i][j]);
            }
        }
        for (int i = 0; i < map.length; i++) {
            int p = point.getOrDefault(i, 0);
            for(int j = 0; j < map.length; j++) {
                p -= map[j][i];
            }
            point.put(i, p);
        }


        for (int i = 0; i < map.length; i++) {
            //준사람 돌면서
            for(int j = i; j < map.length; j++) {
                if (i==j) continue;
                if (map[i][j] == map[j][i] || (map[i][j] == 0 && map[j][i] == 0)) { // 주고 받은 선물이 같거나 기록이 없다면
                    if (point.get(i) > point.get(j)) {
                        arr[i]++;
                    } else if (point.get(i) < point.get(j)) {
                        arr[j]++;
                    }
                } else if (map[i][j] > map[j][i]) { // i가 더 많이 줬다면
                    arr[i]++;

                } else if (map[i][j] < map[j][i]){// j가 더 많이 줬다면
                    arr[j]++;
                }
            }
        }

        for (int a : arr) {
            answer = Math.max(answer, a);
        }

        return answer;
    }
}
