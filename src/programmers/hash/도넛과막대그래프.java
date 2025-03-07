package programmers.hash;

import java.util.*;

public class 도넛과막대그래프 {
    public int[] solution(int[][] edges) {
        //map에 node 전부 넣어버리고
        //순회하면서 입출력으로 판단한다.
        // int[]는 의 fromCount, toCount
        Map<Integer, int[]> nodes = new HashMap<>();

        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            nodes.putIfAbsent(from, new int[2]);
            nodes.putIfAbsent(to, new int[2]);


            nodes.get(from)[0]++;//나간 횟수
            nodes.get(to)[1]++;//들어온 횟수

        }

        int newNode = 0;
        int dC = 0;
        int eC = 0;
        int mC = 0;

        for (int from : nodes.keySet()) {
            int[] nodeInfo = nodes.get(from);

            if (nodeInfo[1] == 0 && nodeInfo[0] >=2) {
                newNode = from;
            } else if (nodeInfo[1] >=2 && nodeInfo[0] == 2) {
                eC++;
            } else if (nodeInfo[1] > 0 && nodeInfo[0] == 0) {
                mC++;
            }


        }
        int[] answer = new int[4];
        answer[0] = newNode;
        answer[1] = nodes.get(newNode)[0] - mC - eC;
        answer[2] = mC;
        answer[3] = eC;
        return answer;
    }
}
