import java.util.*;

class Solution {
    
    public void sum(int[] elements, Set<Integer> set, int n) {
        for(int i = 0; i < elements.length; i++) {
            int index = i;
            int sum = 0;
            for(int j = 0; j < n; j++) {
                sum += elements[index];
                index = (index + 1) % elements.length;
            }
            set.add(sum);
        }
    }
    
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= elements.length; i++) {
            sum(elements, set, i);
        }
        answer = set.size();
        
        return answer;
    }
}