package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int s = Integer.parseInt(br.readLine());
        int[][] n = new int[s][2];

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            n[i][0] = Integer.parseInt(st.nextToken());
            n[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(n, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        int sum = n[0][1] - n[0][0];
        int end = n[0][1];//아래 포문을 돌면 end는 현재까지 iteration한 선분들 중 가장 큰 끝 값을 지님

        for (int i = 1; i < s; i++) {
            if (n[i][1] <= end) {//포함된다면
                //아무것도 하지 않는다.
            }
            else if (n[i][0] < end && end < n[i][1]) {// 선분을 연장한다면
                sum += n[i][1] - end;//추가분만큼 sum에 add
                end = n[i][1];//새로 들어온 놈의 끝이 클때만 end갱신

            }
            else if (end <= n[i][0]) {// 새로운 선분을 만든다면
                sum += n[i][1] - n[i][0];//추가분만큼 sum애 add
                end = n[i][1];//새로 들어온 놈의 끝이 클때만 end갱신
            }
        }
        System.out.println(sum);
    }
}
