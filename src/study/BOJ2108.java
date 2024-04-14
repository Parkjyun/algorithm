package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n  = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        sb.append(average(arr) + "\n");
        sb.append(center(arr) + "\n");
        sb.append(mostSeen(arr) + "\n");
        sb.append(range(arr) + "\n");

        System.out.println(sb);
    }

    private static int average(int[] arr) {
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (int)Math.round(sum / arr.length);
    }
    private static int center(int[] arr) {
        return arr[arr.length/2];
    }

    //111222222333333
    private static int mostSeen(int[] arr) {
        int recent = arr[0];
        int mostseen  = 0;
        boolean isFirst = false;
        int[] count = new int[8001];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + 4000]++;//count에 인덱스에 해당하는 수++
        }
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                mostseen = i - 4000;
                max = count[i];
                isFirst = true;
            } else if (count[i] == max && isFirst) {
                mostseen = i - 4000;
                isFirst = false;
            }
        }
        return mostseen;
    }
    private static int range(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return max - min;
    }


}
