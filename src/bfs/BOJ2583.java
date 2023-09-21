package bfs;

import java.util.*;

//왼위3,2  오룬아래1,4
public class BOJ2583 {
    static int n;
    static int m;
    static int k;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int count = 0;
    static int size;
    static ArrayList<Integer> sizes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        map = new int[m][n];//x는 7까지 y는 5까지
        visited = new boolean[m][n];

        for(int i = 0; i < k; i++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            int t3 = sc.nextInt();
            int t4 = sc.nextInt();
            for(int x = t1; x < t3; x++) {//0-4 // 지금 축을 틀었지만
                for(int y = t2; y < t4; y++) {//2-4
                    map[x][y] = 1;
                    visited[x][y] = true;

                }
            }
        }
        bfs();
        System.out.println(count);
        Collections.sort(sizes);
        for(Integer a : sizes) {
            System.out.print(a + " ");
        }



    }

    static void bfs() {
//0만 세워야 돼 1은 취급하지 않아, 기본은 0, 내가
//map이 1이라면 막혀있는 길이다
        for(int i = 0; i < m; i++) {//7
            for (int j = 0; j < n; j++) {//모든 칸에 대해서//5
                if (visited[i][j] || map[i][j] == 1) continue;//방문했거나
                count++;//전체수 하나 올리고
                size = 0;//사이즈는 0으로 초기화하고
                queue.offer(new Point(i, j));//큐에 값을 넣고//시드를 넣는 것인데
                visited[i][j] = true;
                while (!queue.isEmpty()) {
                    Point p = queue.poll();
                    size++;
                    for (int l = 0; l < 4; l++) {
                        int nx = p.x + dx[l];
                        int ny = p.y + dy[l];
                        if (nx >= 0 && ny >= 0 && nx < m && ny < n) {//0123456, 01234
                            if (!visited[nx][ny] && map[nx][ny] == 0) {//방문하지 않았고 갈수있는 길이라면
                                queue.offer(new Point(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }

                    }
                }
                sizes.add(size);
            }
        }
    }



    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
}
