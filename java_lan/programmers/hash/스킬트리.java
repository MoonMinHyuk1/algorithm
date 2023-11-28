import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }
        for(int i = 0; i < skill_trees.length; i++) {
            String str = skill_trees[i];
            int index = 0;
            boolean flag = true;
            for(char c: str.toCharArray()) {
                Integer next = map.get(c);
                if(next == null) {
                    continue;
                }
                if(next == index) {
                    index++;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                answer++;
            }
        }
        
        return answer;
    }
}