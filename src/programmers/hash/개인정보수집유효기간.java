package programmers.hash;

import java.util.*;
import java.time.*;

public class 개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //1일이면 무조건 28일로 12 + m - 1 %12 나머지는 3 + m % 12
        //today == 오늘 날짜 -> 파기??
        //약관의 유효기간 == n개 -> terms "약관종류 유효기간"
        // 개인정보 "YYYY.MM.DD 약관종류"
        //1. terms map으로 종류, 유효
        //2. privacies 번호, 끝나는 날짜로 mapping

        Map<String, Integer> contract = new HashMap<>();

        for(String term : terms) {
            String[] s = term.split(" ");
            contract.put(s[0], Integer.parseInt(s[1]));//종류, 유효기간
        }

        Map<Integer, String> map = new HashMap<>();//index, endDate
        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            int month = contract.get(s[1]); // 계약일 수 갖고옴


            String endDate = calculate(s[0], month);
            map.put(i, endDate);
        }

        return find(map, today);
    }


    int[] find(Map<Integer, String> map, String today) {
        List<Integer> answer = new ArrayList<>();

        for(Map.Entry<Integer, String> e : map.entrySet()) {
            if (pagi(e.getValue(), today)) {
                answer.add(e.getKey());
            }
        }
        return answer.stream().mapToInt(i -> i+1).toArray();
    }

    boolean pagi (String eDate, String today) {//today가 크면 파기

        String eY = eDate.split("\\.")[0];
        String eM = eDate.split("\\.")[1];
        String eD = eDate.split("\\.")[2];
        String y = today.split("\\.")[0];
        String m = today.split("\\.")[1];
        String d = today.split("\\.")[2];

        LocalDate e = LocalDate.of(Integer.parseInt(eY),Integer.parseInt(eM), Integer.parseInt(eD));
        LocalDate n = LocalDate.of(Integer.parseInt(y), Integer.parseInt(m), Integer.parseInt(d));
        //오늘이  파기 같다면? ㄱㅊㄱㅊ 파기가 작아야만
        return n.isAfter(e);



    }

    String calculate(String startDate, int month) {
        String[] d = startDate.split("\\."); //012

        StringBuilder sb = new StringBuilder();
        if(d[2].equals("01")) {
            if ((Integer.parseInt(d[1]) + month - 1)  > 12) {
                int m = (Integer.parseInt(d[1]) + month -1)%12;
                if (m == 0) m = 12;
                sb.append(Integer.parseInt(d[0]) + (Integer.parseInt(d[1]) + month - 1) / 12).append("."); // 년
                sb.append(m).append(".");
                sb.append(28);
            } else { // 01인데  다음으로 넘어가지 않는다면
                int m = (Integer.parseInt(d[1]) + month -1)%12;
                if (m == 0) m = 12;
                sb.append(Integer.parseInt(d[0])).append("."); // 년
                sb.append(m).append(".");
                sb.append(28);
            }
        }
        else {//01이 아니라면
            if ((Integer.parseInt(d[1]) + month) > 12) { // 2
                int m = (Integer.parseInt(d[1]) + month)%12;
                if (m ==0) {
                    m = 12;
                    sb.append(Integer.parseInt(d[0]) + (Integer.parseInt(d[1]) + month) / 12 - 1).append("."); // 년
                } else {

                    sb.append(Integer.parseInt(d[0]) + (Integer.parseInt(d[1]) + month) / 12).append("."); // 년
                }

                sb.append(m).append(".");
                sb.append((Integer.parseInt(d[2]) - 1));
            } else { // 01인데  다음으로 넘어가지 않는다면 // 24dla
                int m = (Integer.parseInt(d[1]) + month);

                sb.append(Integer.parseInt(d[0])).append("."); // 년
                sb.append(m).append(".");
                sb.append((Integer.parseInt(d[2]) - 1));

            }

        }
        return sb.toString();
    }
}
