package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1931 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int []> p;
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        p = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            p.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }

        //1. 종료시간 기준 오름차순 정렬 2. 종료시간이 같다면 시작시간 기준 오름차순 정렬
        Collections.sort(p, Comparator
                .comparingInt((int[] arr) -> arr[1])
                .thenComparingInt(arr -> arr[0]));

        int count = 0;//회의시간
        int endTime = 0;//가장 최근 회의의 종료시간

        for (int i = 0; i < num; i++) {
            if (p.get(i)[0] >= endTime) {//회의 시작 시간이 이전 종료 시간 이후라면
                endTime = p.get(i)[1];//종료시간 갱신
                count++;//회의 수 ++
            }
        }
        System.out.println(count);
    }
}
