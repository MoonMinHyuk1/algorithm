package re;

import java.util.*;

public class Main8_6 {

    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length;
        int index = 0;
        String[] answer = new String[n];
        List<List<Integer>> graph = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int[] before = new int[n];

        for(int i = 0; i < n; i++) {
            map.put(subjects[i], i);
        }
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < course.length; i++) {
            String post = course[i].split(" ")[0];
            String pre = course[i].split(" ")[1];
            graph.get(map.get(pre)).add(map.get(post));
            before[map.get(post)]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(before[i] == 0) {
                answer[index++] = subjects[i];
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            for(int post: graph.get(pre)) {
                if(--before[post] == 0) {
                    answer[index++] = subjects[post];
                    queue.offer(post);
                }
            }
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
