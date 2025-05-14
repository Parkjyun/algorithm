package programmers;

import java.util.*;

public class 불량사용자 {
    boolean[] visited;
    Set<String> set = new HashSet<>();
    int answer = 0;
    String[] users;
    String[] banned;
    Set<String> as = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        users = user_id;
        banned = banned_id;
        visited = new boolean[user_id.length];

        dfs(0, banned_id.length);

        return as.size();
    }


    boolean da(String a, String b) {//a가 banned
        StringBuilder sb = new StringBuilder(b);
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == '*') {
                sb.setCharAt(i, '*');
            }
        }
        return sb.toString().equals(a);
    }

    void dfs(int depth, int obj) {
        if (depth == obj) {//set에 obj개
            List<String> list = new ArrayList<>();
            for (String s : set) {
                list.add(s);
            }
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append(s);
            }
            as.add(sb.toString());
            return;

        }

        for (int i = 0; i < users.length; i++) {
            if(visited[i]) continue;
            // 어차피 순열-> 특정 조합으로 이루어진 순열 중 하나만 통과해도 괜찮아.
            // depth순서대로 순열(user[i])과 비교. -> 중복 방지
            if (da(banned[depth], users[i])) {
                visited[i] = true;
                set.add(users[i]);
                dfs(depth+1, obj);
                set.remove(users[i]);
                visited[i] = false;
            }
        }
    }
}
