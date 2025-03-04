package programmers.bruteforce;

import java.util.Arrays;
import java.util.Collections;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        brown = brown - 4;
        // brown 은 2*(가로 * 세로)
        int[] result = new int[2]; // 가로 세로 길이 가로 길이가 길다.
        for(int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                int l = i;//작다.
                int h = yellow/i;
                if(brown == 2 * (l + h)) {
                    result[1] = l + 2;
                    result[0] = h + 2;
                }
            }
        }
        return result;
    }

}
