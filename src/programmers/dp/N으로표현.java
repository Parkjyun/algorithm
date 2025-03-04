package programmers.dp;

import java.util.*;

public class N으로표현 {
    public int solution(int N, int number) {
        if(N == number) return 1;
        Set<Integer>[] dp = new Set[9];
        dp[1] = new HashSet<>(List.of(N)); //
        int answer = -1;

        for(int i = 2; i < 9; i++) {
            Set<Integer> after = new HashSet<>();

            //순수 연속 넣어준다.
            String sn = "";
            for(int a = 0; a < i; a++) {
                sn +=String.valueOf(N);
            }
            after.add(Integer.parseInt(sn));

            //만약 i가 5라면 1,4     2,3   3,3    4,1
            for(int j = 1; j < i; j++) {//j==1234
                Set<Integer> before1 = dp[j];
                Set<Integer> before2 = dp[i-j];

                for(int operand1 : before1) {
                    for(int operand2 : before2) {
                        after.add(operand1 + operand2);
                        after.add(operand1 * operand2);
                        if (operand1 - operand2 > 0)
                            after.add(operand1 - operand2);
                        if (operand1 % operand2 == 0)
                            after.add(operand1 / operand2);

                    }
                }
            }

            dp[i] = after;
            if (after.contains(number)) {
                answer=i;
                break;
            }
        }
        return answer;
    }
}
