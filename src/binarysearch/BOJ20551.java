package binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] toFind = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            toFind[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = 0; i < m; i++) {
            bw.write(lowerBound(arr, toFind[i]) + "\n");
        }
        bw.flush();
        bw.close();

    }

    //lowerbound -> n보다 같거나 큰 값중 최초로 나오는 index return;
    static int lowerBound(int[] arr, int find) {//만약 n이 7, given 122333444 -> lb(7) -> 7보다 같거나 큰 값이 첨으로 나오는 index = arr.length
        int l = 0;
        int h = arr.length;

        while (l < h) {
            int m = l + (h-l)/2;
            if (find <= arr[m]) { //m이 찾고자하는 값보다 크거나 같으니 답이 될 수 있음, 더 탐색해봐야 알긴 함
                h = m;//arr[m]이 답이 될 수도 있다. 그러니까 h = m -1을 하지 않는다 -1을 해버리면 지금 m은 못 찾음
            } else if (arr[m] < find) {// n > arr[m] m이 찾고자 하는 값보다 작다면 mid 키워야 됨,
                l = m+1;//arr[m]이 n보다 작다면 애초에 답이 될 수 없으니 +1
            }
        }
        if (l < arr.length && arr[l] == find)
            return l;
        else return -1;
    }
}
