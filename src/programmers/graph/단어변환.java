package programmers.graph;

import java.util.*;

public class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        //1. 조건. 방문하지 않았다.
        //2. 조건. 하나의 단어만 차이가 있다.
        //bfs끊기거나 끝까지 갔느넫 없으면 0 return ;
        boolean visited[] = new boolean[words.length];
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));

        while(!q.isEmpty()) {
            Word w = q.poll();
            if (w.word.equals(target)) {
                answer = w.count;
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (isChangeAvailable(w.word, words[i]) && visited[i] == false) {
                    q.offer(new Word(words[i], w.count + 1));
                    visited[i] = true;
                }
            }
        }
        return answer;
    }

    boolean isChangeAvailable(String from, String to) {
        int difCount = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i))
                difCount++;
        }
        return difCount == 1;
    }
    class Word {
        String word;
        int count;

        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
