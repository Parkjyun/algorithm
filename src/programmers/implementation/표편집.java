package programmers.implementation;

import java.util.*;

public class 표편집 {
    public String solution(int n, int k, String[] cmd) {
        Node[] arr = new Node[n];
        Deque<Node> deleted = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(i);
            if (i > 0) {
                Node prev = arr[i-1];
                Node cur = arr[i];
                prev.next = cur;
                cur.prev = prev;
            }
        }
        //시작 노드
        Node node = arr[k];
        Node start = arr[0];

        for (String c : cmd) {
            if (c.length() >= 3) {
                String[] cs = c.split(" ");
                int x = Integer.parseInt(cs[1]);
                if(cs[0].equals("U")) {
                    for (int i = 0; i < x; i++) {
                        if (node.prev != null) {
                            node = node.moveP();
                        }
                    }
                } else if (cs[0].equals("D")) {
                    for (int i = 0; i < x; i++) {
                        if (node.next != null) {
                            node = node.moveN();
                        }
                    }
                }
            } else if (c.equals("C")) { //삭제
                if (node.next == null) {//마지막이라면
                    deleted.push(node);
                    node.prev.next = node.next;//null
                    // n.next.prev = n.prev;
                    node = node.moveP();
                } else if (node.prev == null) {//처음
                    deleted.push(node);
                    // n.prev.next = n.next;
                    node.next.prev = node.prev;//null
                    node = node.moveN();
                } else {//중간이라면
                    deleted.push(node);
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    node = node.moveN();
                }

            } else if (c.equals("Z")) {
                Node restore = deleted.pop();
                if (restore.prev != null) {
                    restore.prev.next = restore;
                }
                if (restore.next != null) {
                    restore.next.prev = restore;
                }

            }
        }
        //시작점으로옴
        while (node.prev != null) {
            node = node.moveP();
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        String[] answer = new String[n];
        Arrays.fill(answer, "X");
        while(node != null) {
            answer[node.i] = "O";

            node = node.moveN();
        }
        for (String s : answer) {
            sb.append(s);
        }
        return sb.toString();

    }

    class Node {
        Node prev;
        Node next;
        int i;
        Node(int i) {
            this.i = i;
        }

        Node moveN() {
            return this.next;
        }
        Node moveP() {
            return this.prev;
        }
    }



}
