package backtracking;

import java.util.Scanner;
//첫번째행(depth = 0)에 둔다
//두번째 행(depth = 1)에 둔다, 이때 두번째 행에 있는 것은 첫번째 행과 같은 열에 있으면 안되고 첫번째행과 대각선으로 인접해 있어도 안된다.....
//....
//....
//같은 열은 체크 안해? -> depth를 for문으로 증가시킴 -> 하나의 조합에서 하나의 depth(열)에는 하나만
public class BOJ9663 {
    static int n;
    static int[] comb;
    static int answer = 0;//초기화 필요가 없다

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        comb = new int[n];

        backtracking(0);
        System.out.println(answer);
    }

    static void backtracking(int depth) {
        if (depth == n) {//자리조합이 완성됨
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            comb[depth] = i;
            if (validate(depth)) {
                backtracking(depth + 1);
            }
        }
    }
    static boolean validate(int column) {
        for(int i = 0; i < column; i++) {
            if(comb[column] == comb[i]) return false;//comb[i]는 전꺼들의 y좌표
            if(Math.abs(comb[column] - comb[i]) == Math.abs(column - i)) return false;
        }

        return true;

    }
}
