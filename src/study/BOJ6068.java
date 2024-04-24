package study;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ6068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] jobs = new int[n][2];//0은 time needed and 1은 due

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jobs[i][0] = Integer.parseInt(st.nextToken());
            jobs[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(jobs, (a, b) -> b[1] - a[1]);
        /*
        * 끝나는 시각 기준으로 내림차순 정렬
        *
        * 01234567891011121314151617181920

        *
        * */
        int start= jobs[0][1];//start는 이전 for의 시
        for (int i = 0; i < n; i++) {
//            if (start < jobs[i][0]) {//이전 시작 시간보다 이번 잡의 소요시간이 크다면
//                start = -1;
//                break;
//            }
            if (jobs[i][1] <= start)//이전 스타드 보다 이번 마감시간이 작거나 같다면
                start = jobs[i][1] - jobs[i][0];
            else {//이전 스타트보다 마감시간이 크다면
                start = start - jobs[i][0];
            }
        }
        if (start < 0) System.out.println(-1);//start가 0보다 작다면 -1출력
        else
            System.out.println(start);
        }

}
