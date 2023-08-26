package backtracking;

import java.util.Scanner;

public class BOJ16987 {
    static int n;
    static int[] s;
    static int[] w;
    static boolean[] smashed;
    static int answer = 0;
    static int temp;
    static boolean allSmashed = false;
    public static void main(String[] args) {
        //계란 내구도와 무게, 계란으로 상대 계란을 치면 내구도가 상대계란의 무게만큼 깍임
        //왼쪽부터 계란들어서 차례로 깸 몇개깸?
//        3계란의 수
//        8 5 : 계란 1의 내구도/ 무게
//        1 100 계란 2의 내구도/ 무게
//        3 5
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n];
        w = new int[n];
        smashed = new boolean[n];
        for(int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        backtracking(0);
        System.out.println(answer);
    }
    static void backtracking(int depth) {

        if(depth == n) {//끝까지 index다 돌았을 때 깬 수를 최신화 한다. -> 주
            temp = 0;
            for(int i = 0; i < smashed.length; i++) {
                if(smashed[i] == true) temp++;
                if(temp > answer) answer = temp;
            }
            return;
        }
        //logic
        for(int i = 0; i < n; i++) {//모든 index에 대하여//obj
            if(depth == i) continue;
            if(smashed[i] == false && smashed[depth] == false) {//주어와 목적어 모두 안꺠져 있어야 로직 실행
                hitEgg(depth, i);
                backtracking(depth + 1);
                recoverEgg(depth, i);
            } else {
                backtracking(depth + 1);
            }
        }
    }
    static void hitEgg(int sub, int obj) {//계란을 친다. 만약 주가 깨져있으면 return
        s[sub] -= w[obj];
        s[obj] -= w[sub];
        if(s[sub] <= 0) smashed[sub] = true;
        if(s[obj] <= 0) smashed[obj] = true;
    }
    static void recoverEgg(int sub, int obj) {
        s[sub] += w[obj];
        s[obj] += w[sub];
        if(s[sub] > 0) smashed[sub] = false;
        if(s[obj] > 0) smashed[obj] = false;
    }
}
