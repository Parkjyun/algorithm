package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17939 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());
        arr = new int[s];
        int[] buy = new int[s];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //구매
        for (int i = 0; i < s; i++) {
            if (hasHigherPrice(i)) {
                buy[i] = arr[i];
            }
        }
        //판매
        int totalProfit = 0;
        for (int i = 0; i < s; i++) {
            if (buy[i] != 0) {//구매한 것에 대해
                totalProfit += arr[getIndexofHightestPrice(i)] - buy[i];
            }
        }
        System.out.println(totalProfit);


    }

    static boolean hasHigherPrice(int index) {
        int k = arr[index];
        for (int i = index+1; i < arr.length; i++) {
            if (k < arr[i]) return true;
        }
        return false;
    }
    static int getIndexofHightestPrice(int index) {
        int k = arr[index];
        int highIndex = index;
        for (int i = index+1; i < arr.length; i++) {
            if (k < arr[i]) {
                k = arr[i];
                highIndex = i;
            }
        }
        return highIndex;
    }
}
