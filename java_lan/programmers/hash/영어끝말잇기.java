import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        
        char c = words[0].charAt(words[0].length() - 1);
        set.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            if(c != words[i].charAt(0) || set.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            c = words[i].charAt(words[i].length() - 1);
            set.add(words[i]);
        }

        return answer;
    }
}