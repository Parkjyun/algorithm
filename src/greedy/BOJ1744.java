package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ1744 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> pn = new ArrayList<>();
    static List<Integer> nn = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            if(c > 0) pn.add(c);
            if(c <= 0) nn.add(c);
        }
        Collections.sort(pn, Collections.reverseOrder());//54321
        Collections.sort(nn);//-5 -4 -3 -2 -1 0

        int sum = 0;
        int i = 0;
        while (i < pn.size()) {
            if ((i + 1) < pn.size() && pn.get(i) >= 2 && pn.get(i+1) >= 2)
                sum += pn.get(i++) * pn.get(i++);
            else
                sum += pn.get(i++);
        }
        i = 0;
        while (i < nn.size()) {
            if ((i + 1) < nn.size())
                sum += nn.get(i++) * nn.get(i++);
            else
                sum += nn.get(i++);
        }
        System.out.println(sum);
    }
}
