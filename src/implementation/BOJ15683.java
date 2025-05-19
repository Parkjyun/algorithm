package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ15683 {
    static int[][] dx1 = {{0}, {1}, {0}, {-1}};
    static int[][] dy1 = {{1}, {0}, {-1}, {0}};
    static int[][] dx2 = {{0,0}, {1,-1}};
    static int[][] dy2 = {{1,-1}, {0,0}};
    static int[][] dx3 = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static int[][] dy3 = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static int[][] dx4 = {{0,-1,0}, {-1,0,1}, {0,1,0}, {1,0,-1}};
    static int[][] dy4 = {{-1,0,1}, {0,1,0}, {1,0,-1}, {0,-1,0}};
    static int[][] dx5 = {{0,1,0,-1}};
    static int[][] dy5 = {{1,0,-1,0}};
    static Map<Integer, int[][]> mapx = new HashMap<>();
    static Map<Integer, int[][]> mapy = new HashMap<>();
    static int count;

    static List<Type> list = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;
    static int baseCount = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        mapx.put(1, dx1);
        mapy.put(1, dy1);
        mapx.put(2, dx2);
        mapy.put(2, dy2);
        mapx.put(3, dx3);
        mapy.put(3, dy3);
        mapx.put(4, dx4);
        mapy.put(4, dy4);
        mapx.put(5, dx5);
        mapy.put(5, dy5);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) baseCount++;
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    list.add(new Type(i,j, map[i][j]));
                }
            }
        }
        dfs(0, new ArrayList<>());
        System.out.println(min);




    }
    static void see(List<Integer> dirIndex) {
        for (int i = 0; i < list.size(); i++) {//각각의 cctv
            int type = list.get(i).type;
            int[][] dxs = mapx.get(type);
            int[][] dys = mapy.get(type);

            int[] dx = dxs[dirIndex.get(i)];
            int[] dy = dys[dirIndex.get(i)];
            for (int a = 0; a < dx.length; a++) { //cctv각 감시방향
                int x = list.get(i).x;
                int y = list.get(i).y;
                while (true) {
                    x += dx[a];
                    y += dy[a];
                    if (x < 0 || y < 0 || x >= map.length || y >= map[0].length) break; //oor
                    if (map[x][y] == 6) break; //벽 만나면
                    if (map[x][y] == 0) { // 빈공간
                        if (!visited[x][y]) { // 방문하지 않았을 때만
                            visited[x][y] = true;
                            count++;
                        }
                    }
                }
            }
        }
    }

    static void dfs(int depth, List<Integer> dirIndex) {
        if (depth == list.size()) {
            for (boolean[] arr : visited) {
                Arrays.fill(arr, false);
            }
            count = 0;
            see(dirIndex);
            min = Math.min(min, baseCount-count);
            return;
        }

        Type type = list.get(depth);
        int[][] dx = mapx.get(type.type);
        for (int i = 0; i < dx.length; i++) { // 4개의 경우에 대해
            dirIndex.add(i);
            dfs(depth+1, dirIndex);
            dirIndex.remove(dirIndex.size()-1);
        }
    }

    static class Type{
        int x, y, type;

        Type(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
