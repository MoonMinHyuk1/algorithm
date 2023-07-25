import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        
        Integer[] arr = Arrays.stream(weights).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i = 0; i < arr.length; i++) {
            Double n = Double.valueOf(arr[i]);
            if(map.containsKey(n)) answer += map.get(n);
            if(map.containsKey(n * 2)) answer += map.get(n * 2);
            if(map.containsKey(n * 3 / 2)) answer += map.get(n * 3 / 2);
            if(map.containsKey(n * 4 / 3)) answer += map.get(n * 4 / 3);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        return answer;
    }
}