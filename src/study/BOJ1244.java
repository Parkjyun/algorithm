package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1244 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];

        StringTokenizer st  = new StringTokenizer(br.readLine());

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        List<int[]> students = new ArrayList<>();

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int[] student = new int[2];
            student[0] = Integer.parseInt(st.nextToken());//남녀
            student[1] = Integer.parseInt(st.nextToken());//수

            students.add(student);
        }

        for (int i = 0; i < students.size(); i++) {
            int[] student = students.get(i);
            if (student[0] == 1) {
                changeMale(arr, student[1]);
            }
            else if (student[0] == 2) {
                changeFemale(arr, student[1]);
            }
        }

        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (i == (i/20)* 20) System.out.print("\n");

        }

    }
    private static void changeFemale(int[] arr, int n) {
        int h = n;
        int l = n;
        changeArr(arr, n);
        while (true) {
            h++;
            l--;
            if (h >= arr.length || l <= 0) break;
            if (arr[h] == arr[l]){
                changeArr(arr, h);
                changeArr(arr, l);
            } else break;

        }
    }

    private static void changeMale(int[] arr, int n) {
        int a = n;
        while (n < arr.length) {
            changeArr(arr, n);
            n = n + a;
        }
    }
    private static void changeArr(int[] arr, int n) {
        if (arr[n] == 1) arr[n] = 0;
        else if (arr[n] == 0) arr[n] = 1;
    }
}
