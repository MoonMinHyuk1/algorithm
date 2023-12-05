import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        double jcd = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        for(int i = 0; i < str1.length() - 1; i++) {
            if(Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i + 1))) {
                String s = str1.substring(i, i + 2);
                map1.put(s, map1.getOrDefault(s, 0) + 1);
            }
        }
        for(int i = 0; i < str2.length() - 1; i++) {
            if(Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i + 1))) {
                String s = str2.substring(i, i + 2);
                map2.put(s, map2.getOrDefault(s, 0) + 1);
            }
        }
        if(map1.isEmpty() && map2.isEmpty()) {
            answer = 65536;
            return answer;
        }
        double same = 0, all = 0;
        for(String key: map1.keySet()) {
            if(map2.containsKey(key)) {
                same += Math.min(map1.get(key), map2.get(key));
                all += Math.max(map1.get(key), map2.get(key));
            } else {
                all += map1.get(key);
            }
        }
        for(String key: map2.keySet()) {
            if(!map1.containsKey(key)) {
                all += map2.get(key);
            }
        }
        jcd = same / all;
        answer = (int) (jcd * 65536);
        
        return answer;
    }
}