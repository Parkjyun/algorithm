package programmers.implementation;

public class 행렬테두리전환하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = i * columns + j + 1;
            }
        }

        for (int a = 0; a < queries.length; a++) {
            int x1 = queries[a][0]-1;
            int y1 = queries[a][1]-1;
            int x2 = queries[a][2]-1;
            int y2 = queries[a][3]-1;

            int[][] nm = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    nm[i][j] = map[i][j];
                }
            }
            int min = Integer.MAX_VALUE;


            for (int i = y1; i < y2; i++) {
                //x = x2
                map[x1][i+1] = nm[x1][i];
                min = Math.min(min, nm[x1][i]);
            }

            for (int i = x1; i < x2; i++) {
                //y = y1
                map[i+1][y2] = nm[i][y2];
                min = Math.min(min, nm[i][y2]);
            }
            for (int i = y2; i > y1; i--) {
                // x = x1
                map[x2][i-1] = nm[x2][i];
                min = Math.min(min, nm[x2][i]);
            }
            for (int i = x2; i > x1; i--) {
                // y = y2
                map[i-1][y1] = nm[i][y1];
                min = Math.min(min, nm[i][y1]);
            }
            answer[a] = min;
        }
        return answer;
    }
}
