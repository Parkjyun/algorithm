package programmers.implementation;

public class 파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] cs = new int[board.length+1][board[0].length+1];

        for (int i = 0; i < skill.length; i++) {//25,000
            int t = skill[i][0];
            int x = skill[i][1];
            int y = skill[i][2];
            int dx = skill[i][3];
            int dy = skill[i][4];
            int amount = skill[i][5];
            if (t == 1) {
                amount *= -1;
            }
            //밤위 나간 것 컷해줘야 돼
            if (dy + 2 < cs[0].length) {
                cs[x+1][dy+2] -= amount;
            }

            if (dx + 2 < cs.length) {
                cs[dx+2][y+1] -= amount;
            }
            if (dx + 2 < cs.length && dy + 2 < cs[0].length) {
                cs[dx+2][dy+2] += amount;
            }
            cs[x+1][y+1] += amount;
        }

        for (int i = 1; i < cs[0].length; i++) {
            for (int j = 1; j < cs.length; j++) {
                cs[j][i] += cs[j-1][i];
            }
        }

        for (int i = 1; i < cs.length; i++) {
            for(int j = 1; j < cs[0].length; j++) {
                cs[i][j] += cs[i][j-1];
            }
        }

        for (int i = 1; i < cs.length; i++) {
            for(int j = 1; j < cs[0].length; j++) {
                board[i-1][j-1] += cs[i][j];
                if (board[i-1][j-1] >=1) answer++;
            }
        }
        return answer;
    }
}
