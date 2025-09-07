package programmers.graph;

import java.util.*;

public class 길찾기게임  {
    List<List<Point>> adj;
    int[][] answer;
    public int[][] solution(int[][] nodeinfo) {
        //1. nodeinfo가지고 map을 만든다.
        //2. 전중후위를 하낟.
        //1. nodeinfo를 pq에 넣는다. -> y내림차순, x 오름차순
        //2. 단계가 낮아질때마다 -> x를 루트에서부터 타고 내려온다. ex. 3 < 8 -> 왼쪽으로 11 -> 오른쪽으로 , 1 -> 8왼 3왼 -> adj로 하고 01로한다.
        adj = new ArrayList<>();
        answer = new int[2][];
        for (int i = 0; i < nodeinfo.length; i++) {
            List<Point> l = new ArrayList<>();
            l.add(null);l.add(null);
            adj.add(l);
        }

        PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> {
            if (a.y == b.y) {
                return a.x - b.x; // x 작은거부터
            } else {
                return b.y - a.y; // y큰거부터
            }
        });

        for (int i = 0; i < nodeinfo.length; i++) {
            pq.offer(new Point(nodeinfo[i][0], nodeinfo[i][1], i));
        }

        Point start = pq.poll();
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            //어디에 들어갈지 찾아야돼.
            if (p.x < start.x) {
                find(p, adj.get(start.n), 0);
            } else {
                find(p, adj.get(start.n), 1);
            }
        }

        List<Integer> jl = new ArrayList<>();
        List<Integer> hl = new ArrayList<>();
        j(start, jl);
        h(start, hl);
        answer[0] = jl.stream().mapToInt(i->i).toArray();
        answer[1] = hl.stream().mapToInt(i->i).toArray();
        return answer;
    }
    void j(Point p, List<Integer> result) {
        List<Point> childs = adj.get(p.n);
        result.add(p.n+1);
        if (childs.get(0) != null) {
            j(childs.get(0), result);
        }
        if (childs.get(1) != null) {
            j(childs.get(1), result);
        }

    }
    void h(Point p, List<Integer> result) {
        List<Point> childs = adj.get(p.n);

        if (childs.get(0) != null) {
            h(childs.get(0), result);
        }
        if (childs.get(1) != null) {
            h(childs.get(1), result);
        }
        result.add(p.n+1);

    }

    void find(Point obj, List<Point> compare, int way) {

        if(way == 0) {
            if(compare.get(0) == null) {
                compare.set(0, obj);
                return;
            }
        } else {
            if(compare.get(1) == null) {
                compare.set(1, obj);
                return;
            }
        }

        Point p = compare.get(way);
        if (obj.x < p.x) {
            find(obj, adj.get(p.n), 0);
        } else {
            find(obj, adj.get(p.n), 1);
        }
    }

}

class Point {
    int x;
    int y;
    int n;//number

    Point (int x, int y, int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }
}
