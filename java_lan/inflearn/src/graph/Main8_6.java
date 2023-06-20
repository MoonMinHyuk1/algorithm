package graph;

import java.util.*;

public class Main8_6 {

    String[] answer;
    Map<String, Boolean> map;
    Map<String, Set<String>> graph;
    int index;

    public void dfs(String key) {
        for(String value: graph.get(key)) {
            if(!map.get(value)) {
                dfs(value);
            }
        }
        map.put(key, true);
        answer[index++] = key;
    }

    public String[] solution(String[] subjects, String[] course){
        answer = new String[subjects.length];
        map = new HashMap<>();
        graph = new HashMap<>();
        index = 0;

        for(int i = 0; i < subjects.length; i++) {
            map.put(subjects[i], false);
            graph.put(subjects[i], new HashSet<>());
        }
        for(int i = 0; i < course.length; i++) {
            String post = course[i].split(" ")[0];
            String pre = course[i].split(" ")[1];
//            graph.putIfAbsent(post, new HashSet<>());
            graph.get(post).add(pre);
        }
        for(String key: graph.keySet()) {
            if(map.get(key)) continue;
            dfs(key);
        }

        return answer;
    }

    public static void main(String[] args){
        Main8_6 T = new Main8_6();
        System.out.println(Arrays.toString(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"})));
    }
}
