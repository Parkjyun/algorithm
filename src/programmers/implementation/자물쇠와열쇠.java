package programmers.implementation;

public class 자물쇠와열쇠 {
    int k;
    int l;
    public boolean solution(int[][] key, int[][] lock) {
        k  = key.length;
        l = lock.length;

        boolean answer = true;

        for(int t = 0; t < 4; t++) {



            ////모든 케이스에 대해 가능한 모든 점에 대해
            for (int i = 0; i <= l + k -2; i++) {
                for (int j = 0; j <= l+k-2; j++) {


                    //map 중간에 락넣어서 초기화
                    int[][] map = new int[l + 2*(k-1)][l + 2*(k-1)];
                    for (int a = k-1; a <= k + l -2; a++) {
                        for (int b = k-1; b <= k + l -2; b++) {
                            map[a][b] = lock[a-k+1][b-k+1];
                        }
                    }

                    for (int a = 0; a < k; a++) {
                        for (int b = 0; b < k; b++) {
                            map[i+a][j+b] += key[a][b];
                        }
                    }
                    //하나의 케이스에 대해 락을 모두 더함
                    //락 풀렸는지
                    if (check(map)) {
                        return true;
                    }

                }
            }
            key = turn(key);
        }

        return false;
    }

    public boolean check(int[][] map) {
        boolean pass = true;
        for (int i = k-1; i < k + l -1; i++) {
            for (int j = k-1; j < k + l -1; j++) {
                if (map[i][j] == 2 || map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] turn (int[][]key) {
        int turned[][] = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                turned[j][key.length-1-i] = key[i][j];
            }
        }
        return turned;
    }
}
