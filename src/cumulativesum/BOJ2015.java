package cumulativesum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] psum = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1;i <= n; i++) {
            psum[i] = psum[i-1] + Integer.parseInt(st.nextToken());
        }

        //a   b
        // b - a = k
        // a = b-k;
        // b입장에서 k만큼 뺀게 앞에 얼마나 있는가?
        Map<Integer, Integer> map = new HashMap<>();
        //0 1 2 3 4  5  0
        //0 1 3 6 10 15 15

        long answer = 0;
        for (int i = 0;i <= n; i++) {
            int obj = psum[i] - k;

            if (map.get(obj) == null) {

            } else {
                answer += map.get(obj);
            }
            map.put(psum[i], map.getOrDefault(psum[i], 0) + 1);
        }
        System.out.println(answer);
    }
}
