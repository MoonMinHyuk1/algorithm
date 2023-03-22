import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        TreeMap<Integer, String> tree = new TreeMap<>();
        HashMap<String, TreeMap<Integer, List<Integer>>> music = new HashMap<>();
        
        //장르 - 재생횟수
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        map.values().forEach(v -> {
            map.keySet().forEach(k ->{
                if(map.get(k).equals(v)) tree.put(v, k);
            });
        });
        //장르 - 재생횟수 - 고유번호
        for(int i = 0; i < genres.length; i++) {
            music.put(genres[i], music.getOrDefault(genres[i], new TreeMap<>()));
            TreeMap<Integer, List<Integer>> playMusic = music.get(genres[i]);
            playMusic.put(plays[i], playMusic.getOrDefault(plays[i], new ArrayList<>()));
            playMusic.get(plays[i]).add(i);
        }
        
        //장르별 재생횟수 역순
        for(Integer playGenres : tree.descendingKeySet()) {
            //장르별 음악재생횟수 역순
            int cnt = 0;
            for(Integer playMusic : music.get(tree.get(playGenres)).descendingKeySet()) {
                for(Integer number : music.get(tree.get(playGenres)).get(playMusic)) {
                    answer = Arrays.copyOf(answer, answer.length + 1);
                    answer[answer.length - 1] = number;
                    cnt++;
                    if(cnt >= 2) break;
                }
                if(cnt >= 2) break;
            }
        }
        
        return answer;
    }
}