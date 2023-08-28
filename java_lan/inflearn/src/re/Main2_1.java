package re;

import java.util.HashMap;
import java.util.Map;

public class Main2_1 {

    public int solution(String s){
        int answer = -1;
        Map<Character, Integer> map = new HashMap<>();

        for(Character c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                answer = i + 1;
                break;
            }
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
