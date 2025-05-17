package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20366RE {
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

            for (int i = 0; i < arr.length; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    if (j - i <= 2) continue;
                    // 가운데가 있다면

                    int l = i+1;
                    int r = j-1;
                    int outer = arr[i] + arr[j];
                    while (l < r) {
                        int inner = arr[l] + arr[r];
                        if (min > Math.abs(outer - inner)) {
                            min = Math.abs(outer - inner);
                        }
                        if (inner > outer) {
                            r--;
                        } else if (inner < outer) {
                            l++;
                        } else {
                            min = 0;
                            break;
                        }
                    }
                }
            }
            System.out.println(min);
    }
}
