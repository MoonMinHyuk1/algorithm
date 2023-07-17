import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> user1 = new HashSet<>();
        Set<Integer> user2 = new HashSet<>();
        
        for(int i = 0; i < topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
            user2.add(topping[i]);
        }
        for(int i = 0; i <topping.length; i++) {
            int n = topping[i];
            map.put(n, map.get(n) - 1);
            user1.add(n);
            if(map.get(n) == 0) {
                user2.remove(n);
            }
            if(user1.size() == user2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}