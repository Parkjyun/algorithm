package ss;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15686 {
    static List<Point> cL;
    static List<Point> pL;
    static int n;
    static int m;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];


        cL = new LinkedList<>();
        pL = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    cL.add(new Point(i, j));
                }
                if (map[i][j] == 1) {
                    pL.add(new Point(i, j));
                }
            }
        }
        visited = new boolean[cL.size()];
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int start) {
        if (depth == m) {
            //모든 chosen에 대해서 pL iterate하면서 최값을 구한다.
            int cd = 0;
            for (Point p : pL) {
                int individualMin = Integer.MAX_VALUE;
                for (int i = 0; i < cL.size(); i++) {
                    if (visited[i]) {
                        Point c = cL.get(i);
                        int distance = Math.abs(p.x - c.x) + Math.abs(p.y - c.y);
                        individualMin = Math.min(distance, individualMin);
                    }


                }
                cd += individualMin;


            }
            answer = Math.min(answer, cd);
            return;
        }

        for (int i = start; i < cL.size(); i++) {
            visited[i] = true;
            dfs(depth+1, i+1);
            visited[i] = false;
        }

    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}
