package programmers.implementation;

import java.util.HashMap;

import java.util.*;

public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        //fees는 기본시간, 기본요금, 단위시간, 단위 요금
        //각각의 records는      시각 차량번호 내역
        int[] answer = {};
        Map<Integer, Info> map = new HashMap<>();

        StringTokenizer st;
        for (String r : records) {
            st = new StringTokenizer(r);

            String time = st.nextToken();
            String t[] = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);

            int number = Integer.parseInt(st.nextToken());

            String type = st.nextToken(); //IN, OUT

            if (type.equals("IN")) {
                Info p = map.getOrDefault(number, new Info(0,0,0, true));
                p.setTime(h,m);
                map.put(number, p);
            } else {
                //출차라면 t만 update
                Info info = map.get(number);
                info.calculate(h,m);
                System.out.println(number + ":" +info.t);
            }


        }

        for(Map.Entry<Integer, Info> car : map.entrySet()) {
            if (car.getValue().in) { //들어와 있다면
                car.getValue().calculate(23, 59);
                System.out.println(car.getKey() + ":" +car.getValue().t);
            }
        }

        //번호, 값
        List<int[]> list = new LinkedList<>();
        for(Map.Entry<Integer, Info> car : map.entrySet()) {
            list.add(new int[] {car.getKey(), car.getValue().t});
        }
        Collections.sort(list, (a,b) -> {return a[0] - b[0];});


        return list.stream().mapToInt(a -> convert(a[1], fees)).toArray();

    }
    class Info {
        int t;//총 누적 시간
        int h;//들어온시간
        int m;// 들어온 시간
        boolean in;

        void calculate(int h, int m) {//얘네가 더 큼
            int v = (h -this.h) * 60;
            v += m - this.m;
            this.t += v;
            this.in = false;
        }

        void setTime(int h, int m) {
            this.h =h;
            this.m = m;
            this.in = true;
        }

        Info(int t, int h, int m, boolean in) {
            this.t = t;
            this.h = h;
            this.m = m;
            this.in = in;
        }
    }

    int convert(int time, int[] fees) {
        if (time <= fees[0]) {
            return fees[1];
        } else {
            return fees[1] + fees[3] * (int)Math.ceil((double)(time - fees[0]) / fees[2]);
        }
    }
}
