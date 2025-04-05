package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2143 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        List<Integer> partA = new ArrayList<>();
        List<Integer> partB = new ArrayList<>();

        int obj = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        Integer[] arr1 = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < arr1.length; i++) {// 끝 1312
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum+= arr1[j];
                partA.add(sum);
            }

        }


        int m = Integer.parseInt(br.readLine());
        Integer[] arr2 = new Integer[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < arr2.length; i++) {// 끝 1312
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum+= arr2[j];
                partB.add(sum);
            }
        }

        //partA, partB에 모두 들어감
        Collections.sort(partA);
        Collections.sort(partB);

        int start = 0; //idx이다
        int end = partB.size()-1;
        long answer = 0;

        while (start <= partA.size()-1 && end >= 0) {
            int a = partA.get(start);
            int b = partB.get(end);
            if (partA.get(start) + partB.get(end) == obj) {
                long countA = 0;
                long countB = 0;
                while(start <= partA.size()-1 && partA.get(start) == a) {
                    countA++;
                    start++;
                }
                while (end >= 0 && partB.get(end) == b) {
                    countB++;
                    end--;
                }
               answer += countA*countB;
            } else if (partA.get(start) + partB.get(end) > obj) {
                end--;
            } else if (partA.get(start) + partB.get(end) < obj) {
                start++;
            }
        }
        System.out.println(answer);

    }
}
