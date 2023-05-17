package hash_parsing;

import java.util.*;

public class Main2_2 {

    public int[] solution(String s){
        int[] answer = new int[5];
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
        }
        Arrays.fill(answer, max);
        for(char c : map.keySet()) {
            answer[c - 'a'] = max - map.get(c);
        }

        return answer;
    }

    public static void main(String[] args){
        Main2_2 T = new Main2_2();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
