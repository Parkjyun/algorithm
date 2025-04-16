package programmers.dfsbfs;

public class 미로탈출명령어 {
    int[] dx = {1,0,0,-1};
    int[] dy = {0,-1,1,0};
    String[] dc = {"d", "l", "r", "u"};
    String answer = "impossible";
    int obj;
    boolean flag = false;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {


        int[][] map = new int[n+1][m+1];
        obj = k;

        StringBuilder sb = new StringBuilder();
        dfs(n,m,x,y,r,c,k-1,0,sb);
        return answer;
    }

    void dfs(int n, int m, int x, int y, int r, int c, int k, int depth, StringBuilder sb) {//이동해야 하는 거리 == k 계속 k--해줘야 함
        if (depth == obj) {
            if (x == r && y == c) {
                answer = sb.toString();
                flag = true;
                return;
            }
        }

        for(int i = 0; i < 4; i++) {
            if(flag) return;

            System.out.println(k + dc[i]);

            int nx = x +  dx[i];
            int ny = y +  dy[i];
            int distance = getD(nx, ny, r, c);
            if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
            if(distance > k) continue;
            if(distance < k && (k-distance) % 2 == 1) continue;
            sb.append(dc[i]);
            dfs(n,m, nx, ny, r,c, k-1, depth+1, sb);
            sb.delete(sb.length()-1,sb.length());
        }
    }

    int getD(int x, int y, int dx, int dy) {
        return Math.abs(x-dx) + Math.abs(y-dy);
    }
}
