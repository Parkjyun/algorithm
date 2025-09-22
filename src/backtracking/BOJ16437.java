package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16437 {
    static boolean[] visited; // visited면 다음에 ㄴㄴ
    static Set<Integer> start = new HashSet<>();//양들 넣어 놓는것
    static List<List<Integer>> adj = new ArrayList<>();
    static Map<Integer, Point> map = new HashMap<>();
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n;i++) {
            adj.add(new ArrayList<>());
        }
        visited = new boolean[n+1];

        for (int i = 2; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("S")) { //i가 양이라면
                int q = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj.get(to).add(i);
                map.put(i, new Point("S", q));
            } else {
                int q = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj.get(to).add(i);
                map.put(i, new Point("W", q));
            }
        }
        map.put(1, new Point("S", 0));

        System.out.println(solve(1));
    }
    static long solve(int start) {
        long result = 0;
        for (int c : adj.get(start)) {
            result += solve(c);
        }
        //자식들 가져옴
        if (map.get(start).type.equals("S")) {
            return result + map.get(start).q;
        } else {
            if (map.get(start).q >= result) {
                result = 0;
            } else {
                result -= map.get(start).q;
            }
        }
        return result;
    }

    static class Point {
        String type;
        int q;

        Point(String type, int q) {
            this.type = type;
            this.q = q;
        }
    }
}
