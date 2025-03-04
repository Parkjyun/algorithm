package programmers.bruteforce;

public class 피로도 {
    int maxD = 0;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        //k는 나의 피로도
        // k 1이상 8 이하 각각 최소 필요 피로도 >= 소모 피로도 각각 1이상 1000이하
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return maxD;
    }

    void dfs(int depth, int currentP, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {

            if (!visited[i] && currentP >= dungeons[i][0]) {//방문하지 않았고 피가 된다면
                visited[i] = true;
                dfs(depth+1, currentP - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        //매 dfs마다  갱신
        maxD = Math.max(maxD, depth);
    }
}
