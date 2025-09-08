package programmers.greedy;

import java.util.*;

public class n1카드게임  {


    Set<Integer> mine = new HashSet<>();
    Set<Integer> deck = new HashSet<>();
    public int solution(int coin, int[] cards) {
        int l = cards.length;
        for (int i = 0; i < l/3; i++) {
            mine.add(cards[i]);
        }
        int round = 0;
        boolean flag = true;
        for (int i = l/3; i < l; i+=2) {
            round++;
            deck.add(cards[i]);
            deck.add(cards[i+1]);
            //기존 내걸로만 할 수 있다면
            if(frommine(cards)) {
                continue;

            }
            //하나 살때
            else if (coin >= 1&& buyone(cards)) {
                coin--;
            }
            // 두개살때
            else if (coin >= 2 && buytwo(cards)) {
                coin-=2;
            }
            else {
                flag = false;
                break;
            }
        }

        if(flag) {
            round++;
        }
        return round;
    }

    boolean buyone(int[] cards) {
        for (int i : mine) {
            for (int j : deck) {
                if (i + j == cards.length + 1) {
                    mine.remove(i);
                    deck.remove(j);
                    return true;
                }
            }
        }
        return false;
    }
    boolean buytwo(int[] cards) {
        for (int i : deck) {
            for (int j : deck) {
                if ((i!=j) && i + j == cards.length + 1) {
                    deck.remove(i);
                    deck.remove(j);
                    return true;
                }
            }
        }
        return false;
    }

    boolean frommine(int[] cards) {
        for (int i : mine) {
            for (int j : mine) {
                if (i == j) continue;
                if (i + j == cards.length + 1) {
                    mine.remove(i);
                    mine.remove(j);
                    return true;
                }
            }
        }
        return false;
    }
}
