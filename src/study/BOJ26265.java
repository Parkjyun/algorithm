package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ26265 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //compatator 재정의시 값이 양수 -> 첫번째 인자가 크다 == 뒤에 나온다.
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<MM> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    //만약 멘토의 이름이 같다면 menti를 기준으로 역사전순으로 정렬하여라
                    if (o1.mento.compareTo(o2.mento) == 0) {// mento 이름이 갖다면 , o1기준 오름차순(사전식으로 비교)
                        return o2.menti.compareTo(o1.menti);//o2기준 멘티 정렬 -> o1기준으로는 사전 역순
                        //멘토의 이름이 같지 않은 경우는 멘토 이름 기준으로 사전식
                    } else return o1.mento.compareTo(o2.mento);//o1기준 멘토 사전식으로 정렬
                }
        );
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new MM(st.nextToken(), st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            MM mm = pq.poll();
            sb.append(mm.mento + " " + mm.menti + "\n");
        }
        System.out.println(sb);

    }

    static class MM {
        String mento;
        String menti;

        public MM(String mento, String menti) {
            this.mento = mento;
            this.menti = menti;
        }
    }
}
