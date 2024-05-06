package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14650 {
    static int n;
    static int[] ans;
    static int count = 0;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = new int[n];
        System.out.println(backtracking(0));
    }
    static int backtracking(int depth) {
        if (depth == n) {
            sum = 0;
            for (int i = 0; i < ans.length; i++) {
                sum += ans[i];
            }
            if (sum % 3 == 0) count++;
            return count;
        }
        for (int i = 0; i < 3; i++) {
            if (depth == 0 && i == 0) continue;
            ans[depth] = i;
            backtracking(depth+1);
        }
        return count;
    }
}
