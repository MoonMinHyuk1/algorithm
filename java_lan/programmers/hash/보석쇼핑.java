import java.util.*;

class Solution {
    
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        for(int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        boolean flag = false;
        int start = 0, len = gems.length;
        for(int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            queue.offer(gems[i]);
            if(map.size() == set.size()) {
                while(!queue.isEmpty()) {
                    if(map.get(queue.peek()) > 1) {
                        start++;
                        map.put(queue.peek(), map.get(queue.peek()) - 1);
                        queue.poll();
                    } else {
                        break;
                    }
                }
                if(i - start < len) {
                    len = i - start;
                    answer[0] = start + 1;
                    answer[1] = i + 1;
                }
            }
        }
        
        return answer;
    }
}