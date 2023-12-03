import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        char c = 'A';
        for(int i = 1; i <= 26; i++) {
            map.put(String.valueOf(c++), i);
        }
        int index = 0;
        while(index < msg.length()) {
            int len = 1;
            if(index == msg.length() - 1) {
                list.add(map.get(msg.substring(index)));
                break;
            }
            while(index + len <= msg.length() && map.containsKey(msg.substring(index, index + len))) {
                len++;
            }
            if(index + len == msg.length() + 1) {
                list.add(map.get(msg.substring(index)));
                break;
            }
            map.put(msg.substring(index, index + len), map.size() + 1);
            list.add(map.get(msg.substring(index, index + len - 1)));
            index = index + len - 1;
        }
        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}