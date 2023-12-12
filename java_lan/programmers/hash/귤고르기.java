import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int n: tangerine) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(int val: map.values()) {
            list.add(val);
        }
        Collections.sort(list, Collections.reverseOrder());
        for(int n: list) {
            answer++;
            k -= n;
            if(k <= 0) {
                break;
            }
        }
        
        return answer;
    }
}