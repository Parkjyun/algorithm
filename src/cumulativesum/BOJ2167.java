package cumulativesum;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];

        for (int i = 1; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < arr[i].length; j++) {

                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] psum = new int[n+1][m+1];

        for (int i = 1; i < psum.length; i++) {
            for (int j = 1; j < psum[i].length; j++) {
                psum[i][j] = psum[i][j-1] + arr[i][j];
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1= Integer.parseInt(st.nextToken());;
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int answer = 0;
            for (int x = x1; x <= x2; x++) {
                answer += (psum[x][y2] - psum[x][y1-1]);
            }
            System.out.println(answer);
        }

    }
}
