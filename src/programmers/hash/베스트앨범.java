package programmers.hash;

import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, Map<Integer, Integer>> genreMusic = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
            genreMusic.computeIfAbsent(genres[i],a-> new HashMap<>()).put(i, plays[i]);
        }

        //장르 리스트
        List<String> genreList = new ArrayList<>(genreCount.keySet());
        genreList.sort((a,b) -> genreCount.get(b).compareTo(genreCount.get(a))); // 플레이순 내림차순

        List<Integer> answer = new ArrayList<>();
        for(String genre : genreList) {//각각의 장르에 대해서
            Map<Integer, Integer> idCount = genreMusic.get(genre);
            //장르에 포함된 키들
            List<Integer> ids = new ArrayList<>(idCount.keySet());
            //각각의 장르 내에서 count내림차순
            ids.sort((a,b) -> idCount.get(b).compareTo(idCount.get(a)));
            if(ids.size() < 2) {//장르에 포함된 음악 하나라면
                //id를 하나만 넣음
                answer.add(ids.get(0));
            } else{
                answer.add(ids.get(0));
                answer.add(ids.get(1));
            }
        }
        return answer.stream().mapToInt((a)->a).toArray();
    }
}
