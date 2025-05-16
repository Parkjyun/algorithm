package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1991 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static List<Character>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adj = new List[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            adj[node - 'A'] = new ArrayList<>();
            adj[node - 'A'].add(node);
            adj[node - 'A'].add(st.nextToken().charAt(0));
            adj[node - 'A'].add(st.nextToken().charAt(0));
        }

        pre('A');
        System.out.println(sb);

        sb = new StringBuilder();
        cen('A');
        System.out.println(sb);

        sb = new StringBuilder();
        post('A');
        System.out.println(sb);


    }
    static void cen(int node) {
        if (adj[node- 'A'].get(1) != '.') { //왼쪽있는 경우
            cen(adj[node- 'A'].get(1));
        }
        sb.append(adj[node - 'A'].get(0));
        if (adj[node - 'A'].get(2) != '.') { //왼쪽있는 경우
            cen(adj[node- 'A'].get(2));
        }
    }
    static void post(int node) {
        if (adj[node- 'A'].get(1) != '.') { //왼쪽있는 경우
            post(adj[node- 'A'].get(1));
        }
        if (adj[node - 'A'].get(2) != '.') { //왼쪽있는 경우
            post(adj[node- 'A'].get(2));
        }
        sb.append(adj[node - 'A'].get(0));
    }

    static void pre(int node) {
        sb.append(adj[node - 'A'].get(0));
        if (adj[node- 'A'].get(1) != '.') { //왼쪽있는 경우
            pre(adj[node- 'A'].get(1));
        }
        if (adj[node - 'A'].get(2) != '.') { //왼쪽있는 경우
            pre(adj[node- 'A'].get(2));
        }
    }
}
