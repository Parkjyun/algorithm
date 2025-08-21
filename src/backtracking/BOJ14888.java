package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int n;
    static int[] arr;
    static int[] ops;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        ops = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < ops.length; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 0);
        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int start, int depth) {
        if (depth == n-1) {
            min = Math.min(min, start);
            max = Math.max(max, start);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i]--;
                dfs(op(start, arr[depth+1], i), depth+1);
                ops[i]++;
            }
        }
    }

    static int op(int op1, int op2, int num) {
        if (num == 0) {
            return op1 + op2;
        } else if (num == 1) {
            return op1 - op2;
        } else if (num == 2) {
            return op1 * op2;
        } else {
            return op1 / op2;
        }
    }
}
