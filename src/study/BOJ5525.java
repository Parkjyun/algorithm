package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int ans = 0;
        for (int i = 0; i < s-2; i++) {
            int numofi = 0;
            if (str.charAt(i) == 'O') continue;

            while (str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I') {
                numofi++;
                if (numofi == n) {//조건만족, 오른쪽으로 2칸이동할 것임
                    ans++;
                    numofi--;
                }
                i+=2;
            }
        }
        System.out.println(ans);
    }
}
