package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11000 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Lecture[] ls = new Lecture[n];
        for (int i = 0; i < ls.length; i++) {
            st = new StringTokenizer(br.readLine());
            ls[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(ls);

        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(ls[0].end);

        for (int i = 1; i < n; i++) {
            if (queue.peek() <= ls[i].start)
                queue.poll();
            queue.offer(ls[i].end);
        }
        System.out.println(queue.size());
    }

    static class Lecture implements Comparable {//Lecture class 생성 후 customized 정렬하기 위해 comparable
        int start;
        int end;

        private Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {//compareTo하면 Arrays.sort(ls, Comparator.reverseOrder)은 현재 compareTo 반대로 적용됨
            Lecture l = (Lecture)o;
            if (this.start == l.start) {
                if (this.end > l.end) return 1;
                else if (this.end == l.end) return 0;
                else return -1;
            } else {
                if (this.start > l.start) return 1;//양수 -> this가 크다 -> this의 start가 크다면 더 큰 값임 -> 나중에 나옴
                else if (this.start == l.start) return 0;
                else return -1;// -> 음수 -> this가 작다 -> this의 start가 작다면 작은 값임 -> 먼저 나옴
            }
        }
    }
}
