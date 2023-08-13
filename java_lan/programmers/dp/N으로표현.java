import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int i = 0; i <= 8; i++) {
            map.put(i, new HashSet<>());
        }
        map.get(1).add(N);
        int num = N;
        for(int i = 2; i <= 8; i++) {
            for(int j = 1; j <= i; j++) {
                Set<Integer> set1 = map.get(j);
                Set<Integer> set2 = map.get(i - j);
                for(int s1: set1) {
                    for(int s2: set2) {
                        map.get(i).add(s1 + s2);
                        map.get(i).add(s1 - s2);
                        map.get(i).add(s1 * s2);
                        if(s2 != 0) map.get(i).add(s1 / s2);
                    }
                }
            }
            num = (num * 10) + N;
            map.get(i).add(num);
        }
        for(int key: map.keySet()) {
            if(map.get(key).contains(number)) {
                answer = Math.min(answer, key);
            }
        }
        answer = (answer == Integer.MAX_VALUE) ? -1 : answer;
        
        return answer;
    }
}