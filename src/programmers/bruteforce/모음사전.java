package programmers.bruteforce;

import java.util.*;

public class 모음사전 {
    List<String> list = new ArrayList<>();
    int answer = 0;
    int count = 0;
    String[] alphabet = {"A", "E", "I", "O", "U"};
    public int solution(String word) {

        dfs(0, "", word);

        int i = 0;

        return answer;
    }

    void dfs(int depth, String before, String word) {

        if(word.equals(before)) answer = count;
        if(depth == 5) return;//depth가 1 -> 1자리에 대한 검사
        for (int i = 0; i < alphabet.length; i++) {
            //depth가 0 before = 한자리
            before += alphabet[i];
            count++;
            dfs(depth + 1, before, word);
            before = before.substring(0, before.length() -1);
        }
    }
}
