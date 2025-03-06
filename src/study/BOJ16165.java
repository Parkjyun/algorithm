package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());//걸그룹 수
        int m = Integer.parseInt(st.nextToken());// 문제 수
        Map<String, Set<String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String groupName = br.readLine();
            int memberCount = Integer.parseInt(br.readLine());
            map.put(groupName, new HashSet<>());
            for(int j = 0; j < memberCount; j++) {
                map.get(groupName).add(br.readLine());
            }
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if (type == 0) {//팀에 속한 멤버의 이름들
                Set<String> member = map.get(name);
                List<String> list = new ArrayList<>(member);
                Collections.sort(list);
                for (String s : list) {
                    sb.append(s).append("\n");
                }
            } else { // 해당 멤버가 속한 팀의 이름
                for (Entry<String, Set<String>> entry : map.entrySet()) {
                    if (entry.getValue().contains(name)) {
                        sb.append(entry.getKey()).append("\n");
                    }

                }

            }
        }
        System.out.println(sb);
    }
}
