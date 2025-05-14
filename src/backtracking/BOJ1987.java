package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1987 {
    static char[][] map;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        Set<Character> set = new HashSet<>();
        set.add(map[0][0]);
        dfs(0, set, 0,0);
        System.out.println(max);
    }
    static void dfs(int depth, Set<Character> set, int x, int y) {
        max = Math.max(max, depth + 1);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
            if (!set.contains(map[nx][ny])) {
                set.add(map[nx][ny]);
                dfs(depth+1, set, nx,ny);
                set.remove(map[nx][ny]);
            }
        }
    }
}
