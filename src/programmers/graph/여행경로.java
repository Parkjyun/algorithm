package programmers.graph;

import java.util.*;

public class 여행경로 {
    List<String> answers = new ArrayList<>();
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        //ticket을 한번밖에 못쓴다고
        //dfs
        //      1 icn 넣고 depth = 0
        //     1  티켓 visited하지 않았고 티켓의 출발지가 같다면 넣는다,
        //    1
        //   1  //ticket의 개수 + 1만큼 도달했다면 answers에 넣고 break break!
        // 경로가 2개이상일 경우 알파벳 순서가 앞서야 한다. icn a   icn b있을 때 icn a가 먼저여야함
        dfs(0, tickets, "ICN", "ICN");

        Collections.sort(answers);//알파벳 오름차순으로
        return answers.get(0).split(",");
    }

    void dfs(int depth, String[][] tickets , String start, String route) {
        if (depth == tickets.length) {
            answers.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visited[i]) { //start에서 시작할 수 있는 티켓이 있다면,
                visited[i] = true;
                dfs(depth+1, tickets, tickets[i][1], route + "," + tickets[i][1]);
                visited[i] = false; //해당 티켓에 대해 depth들어갔다가 나오면 다른 dfs에서도 쓸 수 있도록 해제
            }
        }
    }
}
