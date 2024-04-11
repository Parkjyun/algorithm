package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7568 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Point[] points = new Point[n];

        //points 배열에 초기화 완료
        for (int i = 0; i < points.length; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        //배열의 순서대로 등수를 구해서 출력
        int[] grade = new int[n];
        for (int i = 0; i < grade.length; i++)
            grade[i] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (points[i].isBigger(points[j])) grade[j]++;
            }
        }
        for (int i = 0; i < n; i++)
            sb.append(grade[i] + " ");
        System.out.println(sb);
    }

    private static class Point {
        int x;
        int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;

        }

        private boolean isBigger(Point p) {
            if (this.x > p.x && this.y > p.y) return true;
            return false;
        }
    }
}
