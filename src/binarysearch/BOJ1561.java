package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1561 {
    static int n;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        // n명의 아이들
        // m종류의 1인승 놀이기구
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 아이들 수
        M = Integer.parseInt(st.nextToken()); // 놀이기구 종류 수
        arr = new int[M]; // 각 놀이기구의 소요 시간

        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long l = 0;
        long h = (long)max * n;
        long m=0;
        while(l < h) {
            m = l + (h-l)/2;

            if(n <= findDone(m)) {// 시간 줄이자
                h = m;
            } else if (n >= findDone(m)) { // 시간 늘리자
                l = m+1;
            }

        }
//        System.out.println("l" + l);
        //m에는 최적 시간
        long answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if(l % arr[i] != 0) { //이미 반영
                answer += (l/arr[i] + 1);
            } else {
                answer += (l/arr[i]);
            }
        }

        int remainder = n - (int)answer;
//        System.out.println("r" + remainder);
        //remainder번째인데
        for (int i = 0; i < arr.length; i++) {
            if (l % arr[i] == 0) {
                remainder--;
            }
            if (remainder == 0) {
                answer = i;
                break;
            }
        }
        System.out.println(answer+1);


        //시간 최대는 0 - 아이 * 최장
        // 0 - 21
        // 10분에 == Math.ceil(10/2) + Math.ceil(10/3) + m = 10
        // 많다 0 - 9
        // 4분에 == Math.ceil(4/2) + Math.ceil(4/3) = 5
        //적다 5 - 9
        // 7분에 == Math.ceil(7/2) + Math.ceil(7/3) = 7

        // 6분에 Math.ceil(6/2) + Math.ceil(6/3) = 7 !!!!!!!!! 마지막 학생수일 때
        // 이때 나누어 떨어지는것. if 나누어떨어지는 것 여러개라면 처음
        //

        // 5분에 == Math.ceil(5/2) + Math.ceil(5/3) = 5
    }

    static long findDone(long time) {
        long r = M;
        for (int i = 0; i < arr.length; i++) {
            r += time / arr[i];
        }
        return r;
    }
}
