package programmers.dfsbfs;

public class 미로탈출명령어2 {
    int[] dx = {1,0,0,-1};
    int[] dy = {0,-1,1,0};
    String[] dc = {"d", "l", "r", "u"};
    String answer = "impossible";
    int obj;
    boolean flag = false;
    int[][] map;
    StringBuilder SB = new StringBuilder();
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        //크기 nm 출발 xy 목표 rc, k = dist

        //1은 출발 //2는 obj로

        map = new int[n][m];


        map[r-1][c-1] = 2;

        dfs(x-1, y-1, 0, k, new StringBuilder(), r-1, c-1);

        return answer;
    }

    void dfs(int x, int y, int depth, int odist,StringBuilder sb, int ox, int oy) {
        if(flag) return;
        if (depth == odist) {
            if (map[x][y] == 2) {// 목표에 도달
                flag = true;
                answer = sb.toString();
            }
            return;
        }
        int remainingChance = odist - depth;
        int remainingdist = Math.abs(x-ox) + Math.abs(y-oy);
        if(remainingdist > remainingChance || (remainingChance % 2) != (remainingdist % 2)) return;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
            sb.append(dc[i]);
            dfs(nx, ny, depth+1, odist, sb, ox, oy);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
