package programmers.bruteforce;

import java.util.*;

public class 소수찾기 {
    List<Integer> sCandidate = new ArrayList<>();
    boolean[] visited;
    public int solution(String numbers) {

        //cf integer.parseint -> 011은 11로
        int answer = 0;

        int[] n = new int[numbers.length()]; // numbers를 배열로
        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.parseInt(numbers.substring(i, i+1));
        }

        visited = new boolean[numbers.length()];

        for (int i = 1; i <= numbers.length(); i++) {
            dfs(numbers,"" , i);
        }

        for (int candidate : sCandidate) {
            if(isPrime(candidate)) answer++;
        }

        return answer;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //sCandidate에 넣어준다.
    private void dfs(String numbers, String temp, int objDepth) {
        if (temp.length() == objDepth) {
            int intCandidate = Integer.parseInt(temp);
            if (!sCandidate.contains(intCandidate)) {
                sCandidate.add(intCandidate);
                System.out.println(intCandidate);

            }

            return;
        }

        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) { //방문하지 않은 넘들 중에서
                temp += numbers.charAt(i);
                visited[i] = true;
                dfs(numbers, temp, objDepth);
                visited[i] = false;
                temp = temp.substring(0, temp.length() - 1);
            }
        }
    }
}
