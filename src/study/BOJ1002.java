package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1002 {
    public static void main(String[] args) throws IOException {
        int[] a = new int[3];
        int[] b = new int[3];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            st = new StringTokenizer(s);
            a[0] = Integer.parseInt(st.nextToken());
            a[1] = Integer.parseInt(st.nextToken());
            a[2] = Integer.parseInt(st.nextToken());
            b[0] = Integer.parseInt(st.nextToken());
            b[1] = Integer.parseInt(st.nextToken());
            b[2] = Integer.parseInt(st.nextToken());
            int dist = (a[0] - b[0])*(a[0] - b[0]) + (a[1] - b[1])*(a[1] - b[1]);
            int r1r2Dist = a[2]*a[2] + b[2]*b[2] + 2*a[2]*b[2];
            int r1r2DistSub = a[2]*a[2] + b[2]*b[2] - 2*a[2]*b[2];

            if (r1r2Dist < dist) sb.append(0).append("\n");
            else if (r1r2Dist == dist && dist!=0) sb.append(1).append("\n");
            else if (r1r2Dist > dist && dist > r1r2DistSub) sb.append(2).append("\n");
            else if (r1r2DistSub == dist && dist!=0) sb.append(1).append("\n");
            else if (r1r2DistSub > dist) sb.append(0).append("\n");
            else if (dist == 0 && a[2] == b[2]) sb.append(-1).append("\n");

        }
        System.out.println(sb);
    }
}
