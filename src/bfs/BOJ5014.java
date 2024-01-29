package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int f, s, g, u, d;
    static int[] map;
    static boolean[] visited;
    static int answer = 0;
    static int np;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());//건물의 총 수
        s = Integer.parseInt(st.nextToken());//현재 위치
        g = Integer.parseInt(st.nextToken());//스타트링크가 있는 곳
        u = Integer.parseInt(st.nextToken());//위로 u층을 가는 버튼
        d = Integer.parseInt(st.nextToken());//아래로 d층을 가는 버튼   +  u층 위 또는 d층 아래에 해당하는 층이 없을 때는 엘리베이터는 움직이지 않는다.

        bfs();//bfs 실행후
        if (visited[g])//스타트링크에 도달하면 answer 출력
            System.out.println(answer);
        else//스타트 링크에 도달하지 못했다면 use the stairs출력
            System.out.println("use the stairs");
    }

    static void bfs() {
        map = new int[f + 1];//1층 - f층까지 생성 (0은 없는 층 취급)
        visited = new boolean[f + 1];
        int[] dx = {u, -d};//u,d 설정
        Queue<int[]> queue = new LinkedList<>();//[0] -> 위치, [1] -> 움직인 횟수
        int[] start = {s, 0};// 초기값 현재위치, 시도횟수0
        queue.offer(start);//넣음
        visited[s] = true;//방문처리
        while (!queue.isEmpty()) {//bfs시작
            int[] p = queue.poll();//큐 맨 앞 빼서
            for (int i = 0; i < 2; i++) {// 두 가지 방향으로 모두 실행
                np = p[0] + dx[i];// 새 위치 넣고

                if (np < 1 || np > f || visited[np]) continue;//방문한 곳이거나 범위를 벗어나면 continue
                visited[np] = true;//처음 방문하고 범위 충족 -> 방문 처리
                if(np == g)//이때 방문 지역이 스타트링크가 있는 곳이라면
                    answer = p[1] + 1;//answer에 방문횟수 넣음 이때 +1하는 이유는 np새로 초기화할 때 움직인 횟수 초기화해주지 않아서 한번 해줘여함
                queue.offer(new int[]{np, p[1] + 1});//스타트링크가 아니라면 새 point, 시도횟수 +1해서 큐에 넣음
            }
        }
    }
}
