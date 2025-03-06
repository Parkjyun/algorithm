package programmers.hash;

import java.util.*;

public class 다단계칫솔판매 {

    class Person {
        int money;
        String name;
        Person parent;

        Person(int money, String name, Person parent) {
            this.money = money;
            this.name = name;
            this.parent = parent;
        }

        void calculate(int profit) {
            int giveAmount = (int)Math.floor(profit * 0.1);
            this.money += profit - giveAmount;
            if (parent!= null && profit >= 1) {
                parent.calculate(giveAmount);
            }
        }

    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //enroll은 각 판매원의 이름
        //referral각 판매원을 다단계 조직에 넣은 사람들. == 상위
        // referral에서 "-"면 인덱스에 해당한느 사람이 solo
        // 판매량 집계 데이터의 판매원 이름
        // 수량 개당 100원
        Map<String, Person> map = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            String parent = referral[i];
            if (parent == "-") {
                map.put(name, new Person(0, name, null));
            } else {
                map.put(name, new Person(0, name, map.get(parent)));
            }

        }
        //map 완성
        for (int i = 0; i < seller.length; i++) {
            Person person = map.get(seller[i]);

            person.calculate(100 * amount[i]);
        }
        int answer[] = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = map.get(enroll[i]).money;
        }
        return answer;
    }
}
