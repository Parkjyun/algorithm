package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1931RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<int[]> p = new java.util.ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            p.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(p, (o1, o2) -> {// 1. 끝나는 시각 오름 차순, 2. 시작 시간 오름 차순
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int lastTime = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (p.get(i)[0] >= lastTime) {
                answer++;
                lastTime = p.get(i)[1];
            }
        }
        System.out.println(answer);
    }
}
