package programmers;

import java.util.*;

public class 프렌즈4블록  {

    List<List<Integer>> delete = new LinkedList<>();
    boolean flag = true;
    int answer = 0;

    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }


        while (flag) { //deletedp 에 있다면
            find(map);
            // delete에 있는 거 지우고
            for (int i = 0; i < delete.size(); i++) { // i는 열 ex. 0
                Collections.sort(delete.get(i), (a,b) -> b-a);
                for (int r : delete.get(i)) { // r은 행
                    if (map[r][i] == '.') continue;
                    map[r][i] = '.'; // 지워지는 애들 모드 .으로
                }
            }
            //board움직임
            for (int i = 0; i < delete.size(); i++) { // i는 열 ex. 0

                for (int r = map.length - 1; r >= 0; r--) { // r은 행
                    if (map[r][i] != '.') continue;

                    //.이라면
                    for (int a = r-1; a >= 0; a--) { //. 이라면 위에 것들 중에서
                        if(map[a][i] != '.') { // .이 아니라면
                            map[r][i] = map[a][i];

                            map[a][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
            for (int j = 0; j < map[i].length; j++)
                if (map[i][j] == '.') answer++;
        }

        return answer;
    }

    boolean find(char[][] board) { // 돌면서 delete에 넣어버린다.
        flag = false;
        boolean temp = true;
        delete = new LinkedList<>();
        for (int i = 0; i < board[0].length; i++) {
            delete.add(new LinkedList<>()); // 열, 행임
        }

        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {
                char before = board[i][j];
                temp = true;
                outerloop : for (int a = 0; a < 2; a++) {
                    for (int b = 0; b < 2; b++) { // 4개 돌면서
                        if (before == '.' || board[i + a][j+b]!=(before)) { // 4개 돌면서 하나라도 처음과 다르다면 temp = false, 4개 순회 종료
                            temp = false;
                            break outerloop;
                        }
                    }
                }
                if (temp) {
                    flag = true;
                    for (int a = 0; a < 2; a++) {
                        for (int b = 0; b < 2; b++) {
                            delete.get(j + b).add(i + a);
                        }
                    }
                }
            }
        }

        return flag;

    }
}
