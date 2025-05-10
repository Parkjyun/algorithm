package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ7512 {

    static boolean isPrime[];
    public static void main(String[] args) throws IOException {
        int size = 10000001;
        int[] arr = new int[size];
        isPrime = new boolean[size];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }
        // 1- 100
        List<Integer> list = new ArrayList<>();


        for (int i = 2; i <= Math.sqrt(size); i++) {
            if (arr[i] == 0) continue;
            for (int j = 2*i; j < arr.length; j+=i) {
                arr[j] = 0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                list.add(arr[i]);
                isPrime[arr[i]] = true;
            }
        }

        //오름차순으로 list에 소수 들어감.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n;
        int[] cs;
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            cs = new int[n];
            for (int j = 0; j < n; j++) {
                cs[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println("Scenario " + (i+1) + ":");
            System.out.println(find(list, cs) + "\n");
        }

        // n == 2
        // cs == 35


    }
    //list 소수 묶음이 주어진다. cs에 내의 수 n-> 연속하는 소수 n개로 만들 수 있는 가장 작은 소수는? 모두 충족해야함
    static int find(List<Integer> list, int[] cs) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> answers = new ArrayList<>();
        for (int w : cs) {
            //w는 357
            int sum = 0;
            for (int i = 0; i < w; i++) {
                sum += list.get(i);
            }
            if (sum > 0 && sum < 10000000 && isPrime[sum]) { // 소수라면
                System.out.println(sum);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            for(int i = 1; i <= list.size() - w; i++) {
                sum = sum - list.get(i-1);
                sum = sum + list.get(i + w -1);
                if (sum > 0 && sum < 10000000 && isPrime[sum]) { // 소수라면
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == cs.length) {
                answers.add(e.getKey());
            }
        }
        Collections.sort(answers);
        return answers.get(0);
    }
}
