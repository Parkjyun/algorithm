package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ15681 {
    static List<List<Integer>> map = new ArrayList<>();
    static int size[];
    public static void main(String[] args) throws IOException {
        //서브트리 노드 개수 = 100000 -> 십만 dfs
        // 쿼리 개수 = 십만 -> 걍 dfs돌리면 시초 -> 트리 dp
        //size[parent] += sum(size[child])
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) map.add(new ArrayList<>());
        size = new int[n+1];

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        solve(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(size[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
    static void solve(int start) {
        size[start] = 1;

        for (int c : map.get(start)) {
            if (size[c] == 0) { //!visited만
                solve(c);
                size[start] += size[c];
            }

        }
    }
}
