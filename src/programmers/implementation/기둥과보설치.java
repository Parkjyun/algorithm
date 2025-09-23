package programmers.implementation;

import java.util.*;

public class 기둥과보설치  {
    boolean[][] bo;
    boolean[][] pi;
    public int[][] solution(int n, int[][] build_frame) {
        // 기둥. 1. 바딕 2. 기둥위 3. 보의 끝부분위에
        // 버    1. 한쪽 끝이 기둥위에, 다른 양쪽끝이 보와 연결

        bo = new boolean[n+1][n+1];
        pi = new boolean[n+1][n+1];
        for (int i = 0; i < build_frame.length; i++) {
            int[] op = build_frame[i];

            int x = op[0];
            int y = op[1];
            int a = op[2]; // 0기둥 1보
            int b = op[3]; // 0삭제 1설치
            if (a == 0) {
                if (b == 1) {
                    // 기둥 설치

                    if(checkG(x,y,n)) {
                        pi[x][y] = true;
                    }

                } else {
                    pi[x][y] = false;
                    if (canDelete(n)) { //기둥삭제해도 관련 보 2개, 기둥이 만족한다면

                    } else { // 만족 ㄴㄴ-> 원복
                        pi[x][y] = true;
                    }
                }
            } else {
                if (b == 1) {
                    // 보 설치
                    if(checkB(x,y,n)) {
                        bo[x][y] = true;
                    }

                } else {
                    // 보 삭제
                    bo[x][y] = false;
                    if (canDelete(n)) { //기둥삭제해도 관련 보 2개, 기둥이 만족한다면

                    } else { // 만족 ㄴㄴ-> 원복
                        bo[x][y] = true;
                    }
                }
            }
        }
        List<int[]> answer = new ArrayList();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pi[i][j]) {
                    answer.add(new int[] {i,j, 0});
                }
                if (bo[i][j]) {
                    answer.add(new int[] {i,j, 1});
                }
            }
        }
        Collections.sort(answer, (a,b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return a[2] - b[2];
                } else {
                    return a[1] - b[1];
                }
            } else {
                return a[0] - b[0];
            }
        });
        return answer.stream().toArray(int[][]::new);
    }
    // 기둥. 1. 바딕 2. 기둥위 3. 보의 끝부분위에
    boolean checkG(int x, int y, int n) {
        if (y == 0) return true;//바닥
        if (x == 0) {//보의 끝부분위에
            if (bo[x][y]) return true;
        } else {
            if (bo[x-1][y] || bo[x][y]) return true;
        }
        //기둥위
        if(pi[x][y-1]) return true;
        return false;
    }

    //1. 한쪽 끝이 기둥위에, 다른 양쪽끝이 보와 연결
    boolean checkB(int x, int y, int n) {
        if(y==0) return false;
        // 한쪽끝이 기둥위에
        if (pi[x][y-1] || pi[x+1][y-1]) return true;

        if (x == 0) { //양쪽이 보와 연결
            return false;
        } else if (x == n) {
            return false;
        } else {
            if (bo[x-1][y] && bo[x+1][y]) return true;
        }
        return false;
    }
    boolean canDelete(int n) {
        for(int i=0;i<=n;i++)
            for(int j=0;j<= n;j++)
                if(pi[i][j] && !checkG(i, j, n))//기둥이 안돼
                    return false;
                else if(bo[i][j] && !checkB(i, j, n))
                    return false;
        return true;
    }
}
