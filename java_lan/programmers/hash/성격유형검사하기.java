import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], 0);
        }
        for(int i = 0; i < survey.length; i++) {
            if(choices[i] == 4) continue;
            if(choices[i] < 4) {
                char c = survey[i].charAt(0);
                map.put(c, map.get(c) + (4 - choices[i]));
            } else {
                char c = survey[i].charAt(1);
                map.put(c, map.get(c) + (choices[i] - 4));
            }
        }
        for(int i = 0; i < arr.length; i += 2) {
            char c1 = arr[i];
            char c2 = arr[i + 1];
            if(map.get(c1) > map.get(c2)) {
                answer += c1;
            } else if(map.get(c1) < map.get(c2)) {
                answer += c2;
            } else {
                char[] sort = {c1, c2};
                Arrays.sort(sort);
                answer += sort[0];
            }
        }
        
        return answer;
    }
}