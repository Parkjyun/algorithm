package programmers.implementation;

public class 서버증설횟수 {
    public int solution(int[] players, int m, int k) {
        //players는 0-23사람수 준다.
        // m은 서버 한대로 감당 가능한 사람 수
        // k는 서버 유지 시간
        int[] servers = new int[24];
        int answer = 0;

        for (int i = 0; i < 24; i++) {// 매 시간마다
            int neededS = players[i] / m; //현재 이만큼 필요해~
            int currenti = servers[i];

            if (neededS > servers[i]) { //필요한게 많다면
                answer += neededS - servers[i];//증설하면서
                int until = Math.min(24, k+i);

                for (int j = i; j < until; j++) {
                    servers[j] += (neededS - currenti);
                }
            }
        }
        for(int i : servers) {
            System.out.print(i + " ");
        }

        return answer;
    }
}
