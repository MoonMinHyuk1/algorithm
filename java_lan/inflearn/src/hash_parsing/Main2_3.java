package hash_parsing;

import java.util.*;

public class Main2_3 {

    public int solution(String s){
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int n : map.values()) {
            while(set.contains(n)) {
                n--;
                answer++;
            }
            if(n != 0) {
                set.add(n);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main2_3 T = new Main2_3();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
