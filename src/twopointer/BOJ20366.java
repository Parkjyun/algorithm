package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ20366 {
    static int[] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        List<Node> sum = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {// i,j조합
                sum.add(new Node(arr[i] + arr[j], i, j));
            }
        }
        Collections.sort(sum, (a,b) -> {return a.sum - b.sum;}); // sum순서로 오름차순

        int minDiff = Integer.MAX_VALUE;
        outerloop : for (int i = 1; i < sum.size(); i++) {
            for (int j = i-1; j >= 0; j--) {
                Node n1 = sum.get(i);
                Node n2 = sum.get(j);
                int curDiff = n1.sum - n2.sum;//회차
                if (curDiff >= minDiff) break; // 앞으로 더 해봤다 어차피 cd >= md -> break;
                if (n1.a == n2.a || n1.a == n2.b || n1.b == n2.a || n1.b == n2.b) continue;
                //가능조합이라면
                minDiff = curDiff;
                if (minDiff == 0) break outerloop;
            }
        }
        System.out.println(minDiff);
    }

    static class Node {
        int sum;
        int a;
        int b;

        private Node(int sum, int a, int b) {
            this.sum = sum;
            this.a = a;
            this.b = b;
        }
    }
}
