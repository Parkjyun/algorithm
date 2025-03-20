package programmers.hash;

import java.util.*;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {

        Map<String, Integer> map = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();

            if (cacheSize >= 1) {
                if (map.containsKey(city)) { // cachehit!
                    answer+=1;
                    map.put(city, i);
                } else if (map.size() == cacheSize && !map.containsKey(city)) { // cache miss!
                    answer+=5;
                    int min = Integer.MAX_VALUE;
                    String lruKey="";
                    for (Map.Entry<String, Integer> e : map.entrySet()) {
                        if (min > e.getValue()) {//늦게 들어온 놈이라면
                            lruKey = e.getKey();
                            min = e.getValue();
                        }
                    }
                    map.remove(lruKey);
                    map.put(city, i);
                } else if (map.size() < cacheSize && !map.containsKey(city)) {
                    answer += 5;
                    map.put(city, i);
                }
            } else {
                answer = 5 * cities.length;
            }
        }
        return answer;
    }

}
