package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18809 {
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static List<Point> list;
    static List<Point> combList;
    static List<Point> gList;
    static boolean[] visitedComb;
    static int[][] mapg;
    static int[][] mapr;
    static int g;
    static int availablePlace;
    static int n, m;
    static int count;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        // 0 은 호수 1은 배양액을 뿌릴 수 없는 땅, 2는 배양액을 뿌릴 수 있는 땅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        mapg = new int[n][m];
        mapr = new int[n][m];
        list = new ArrayList<>();//배양가능 자리
        combList = new ArrayList<>();//배양자리 1차 조합
        gList = new ArrayList<>();//배양자리 2차 조합
        visitedComb = new boolean[g + r];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    visited[i][j] = true;//호수는 그냥 없애 버린다.
                }
                if (arr[i][j] == 2) { // 배양액을 뿌릴 수 있는 자리
                    list.add(new Point(i, j, 1));//r
                }
            }
        }


        comb(0, 0, g + r);

        System.out.println(max);


        //피울 수 있는 꽃의 최대 개수는?

    }


    //list == 배양액 꽂을 수 있는 공간
    //visitedPlace는 배양액 위치에 대한 visited
    static void comb(int depth, int start, int toImplement) {
        if (depth == toImplement) { // 모든 배양액을 넣었다면
            comb2andgo(0, 0, g);
            return;
        }
        for (int i = start; i < list.size(); i++) {
            combList.add(list.get(i));//고른 것들 새 조합으로 넣음
            comb(depth + 1, i + 1, toImplement);
            combList.remove(list.get(i));
        }
    }


    static void comb2andgo(int depth, int start, int g) {
        if (depth == g) { // 모든 배양액을 넣었다면 // comblist에 다 들어가고 // visitedcomb true -> g
            dfs();
            return;
        }
        for (int i = start; i < combList.size(); i++) {
            visitedComb[i] = true;
            comb2andgo(depth + 1, i + 1, g);
            visitedComb[i] = false;
        }

    }

    static void dfs() {
        mapg = new int[n][m];
        mapr = new int[n][m];
        count = 0;
        // comblist에 다 들어가고 // visitedcomb true -> g
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < combList.size(); i++) {
            if (visitedComb[i]) {//초록


                Point point = combList.get(i);
                q.offer(new Point(point.x, point.y, 0));
                mapg[point.x][point.y] = 1;
                visited[point.x][point.y] = true;

            } else {

                Point point = combList.get(i);
                q.offer(new Point(point.x, point.y, 1));

                mapr[point.x][point.y] = 1;
                visited[point.x][point.y] = true;
            }
        }
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (mapr[p.x][p.y] == mapg[p.x][p.y]) continue;//이전에 넣었는데 꽃이 피었다면

            if (p.t == 0) {
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) //범위 나가면 무시
                        continue;
                    if (arr[nx][ny] == 0) // 호수면 무시
                        continue;
                    if (mapg[nx][ny] >0) // 이미 방문한 green이면 무시 처음 - 이후 1
                        continue;
                    if (mapr[nx][ny] <= mapg[p.x][p.y] && mapr[nx][ny] > 0)  //이전 red 방문 -> 무시
                        continue;
                    if (mapr[nx][ny] == mapg[p.x][p.y] + 1) { // 새 red이면 꽃
                        mapg[nx][ny] = mapg[p.x][p.y] + 1;


                        count++;
                        continue;
                    }
                    q.offer(new Point(nx, ny, 0));
                    mapg[nx][ny] = mapg[p.x][p.y] + 1;
                }
            }

            if (p.t == 1) {
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) //범위 나가면 무시
                        continue;
                    if (arr[nx][ny] == 0) // 호수면 무시
                        continue;
                    if (mapr[nx][ny] != 0) // 이미 방문한 green이면 무시
                        continue;
                    if (mapg[nx][ny] <= mapr[p.x][p.y] && mapg[nx][ny] != 0) //이전 red이면 무시
                        continue;
                    if (mapg[nx][ny] == mapr[p.x][p.y] + 1) { // 새 red이면 꽃
                        mapr[nx][ny] = mapr[p.x][p.y] + 1;
                        count++;
                        continue;
                    }
                    q.offer(new Point(nx, ny, 1));
                    mapr[nx][ny] = mapr[p.x][p.y] + 1;
                }
            }


        }
        max = Math.max(count, max);
    }


    static class Point {
        int x;
        int y;
        int t;//0은 g 1은 R

        Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }

    }
}
