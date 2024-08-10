package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ22862 {
    public static void main(String[] args) throws IOException {
        //n개 중에서 원하는 위치의 원소를 k번 삭제한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int kCount = 0;
        int s = 0;
        int e = 0;
        int answer = 0;
        int count = 0;

        while (e <= n-1) {
            if (kCount < k) { // 찬스 있다면
                if (arr[e]%2 == 0) {//짝수라면 e를 그냥 올려
                    e++;
                    answer = Math.max(answer, e-s-kCount);
                } else {//홀수라면
                    e++;
                    kCount++;
                    answer = Math.max(answer, e-s-kCount);
                }
            } else {//찬스 없다면
                if (arr[e]%2 == 0) {//짝수라면 e를 그냥 올려
                    e++;
                    answer = Math.max(answer, e-s-kCount);
                } else {//찬스 없는데 홀수라면
                    if (arr[s] % 2 == 1) {
                        kCount--;
                    }
                    s++;
                    answer = Math.max(answer, e-s-kCount);
                }

            }
        }
        System.out.println(answer);
    }
}
