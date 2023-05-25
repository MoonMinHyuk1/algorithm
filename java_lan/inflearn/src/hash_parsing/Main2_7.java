package hash_parsing;

import java.util.*;

public class Main2_7 {

    public String[] solution(String[] reports, int time){
        String[] answer = {};
        Map<String, Integer> in = new HashMap<>();
        Map<String, Integer> use = new HashMap<>();
        List<String> user = new ArrayList<>();

        for(String str: reports) {
            String name = str.split(" ")[0];
            int hour = Integer.valueOf(str.split(" ")[1].split(":")[0]);
            int minute = Integer.valueOf(str.split(" ")[1].split(":")[1]);
            int t = hour * 60 + minute;

            if(str.split(" ")[2].equals("in")) {
                in.put(name, t);
            } else {
                int start = in.get(name);
                in.remove(name);
                use.put(name, use.getOrDefault(name, 0) + (t - start));
            }
        }
        for(String key: use.keySet()) {
            if(use.get(key) > time) {
                user.add(key);
            }
        }
        Collections.sort(user, (o1, o2) -> o1.compareTo(o2));
        answer = new String[user.size()];
        for(int i = 0; i < user.size(); i++) {
            answer[i] = user.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        Main2_7 T = new Main2_7();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
