package datastructure;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<Character> s = new LinkedList<>();
        String d = br.readLine();
        for (int i = 0; i < d.length(); i++) {
            s.add(d.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());
        ListIterator<Character> iter = s.listIterator();
        while (iter.hasNext()) iter.next();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String o = st.nextToken();
            if (o.equals("P")) {
                char add = st.nextToken().charAt(0);
                iter.add(add);
            }
            if (o.equals("D")) {
                if (iter.hasNext()) iter.next();

            }
            if (o.equals("B")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            }
            if (o.equals("L")) {
                if (iter.hasPrevious()) iter.previous();

            }
        }

        for (Character c: s) {
            bw.write(c);
        }
        bw.flush();
        bw.close();


    }
}
