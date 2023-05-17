package hash_parsing;

import java.util.*;

public class Main2_1 {

    public int solution(String s){
        int answer = Integer.MAX_VALUE;
        Map<Character, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, new ArrayList<>()));
            List<Integer> list = map.get(c);
            list.add(i);
        }
        for(List<Integer> list : map.values()) {
            if(list.size() == 1) {
                answer = Math.min(answer, list.get(0) + 1);
            }
        }
        if(answer >= s.length() + 1) {
            answer = -1;
        }

        return answer;
    }

    public static void main(String[] args){
        Main2_1 T = new Main2_1();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
