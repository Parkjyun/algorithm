package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9613 {

    boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            long sum = 0;
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[m];
            for (int a = 0; a < m; a++) {
                arr[a] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < m; j++) {
                for (int l = j+1; l < m; l++) {
                    sum += gcd(Math.max(arr[j], arr[l]), Math.min(arr[j], arr[l]));
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);


    }

    static int gcd(int big, int small) {
        int m = big % small;

        if(m == 0) return small;
        return gcd(small, m);
    }
}
