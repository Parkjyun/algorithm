package programmers.implementation;

import java.util.Arrays;

public class 거리두기확인하기 {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    char[][] map;
    boolean flag;
    boolean[][] visited;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer,1);
        for (int i = 0; i < places.length; i++) {
            //한 라운드임
            map = new char[5][5];
            //round마다 flag = true;
            flag = true;
            String[] lines = places[i];
            for (int a = 0; a < 5; a++) {
                String line = lines[a];
                for (int b = 0; b < 5; b++) {
                    map[a][b] = line.charAt(b);
                }
            }

            //한 라운드에 대해 모든 사람에 대해 dfs 시작
            outerloop : for (int a = 0; a < 5; a++) {
                for (int b = 0; b < 5; b++) {
                    if (map[a][b] == 'P') {
                        visited = new boolean[5][5];
                        visited[a][b] = true;
                        dfs(0, a, b);
                        if (flag == false) {
                            answer[i] = 0;
                            break outerloop;
                        }
                    }
                }
            }
        }
        return answer;
    }

    void dfs(int depth, int x, int y) {
        if (depth == 1 && map[x][y] == 'P') {
            flag = false;
            return;
        }
        if (depth == 2) {
            if (map[x][y] == 'P') {
                flag = false;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visited[nx][ny]) continue;
            if (map[nx][ny] == 'X') continue;
            visited[nx][ny] = true;
            dfs(depth+1, nx, ny);
        }
    }
}