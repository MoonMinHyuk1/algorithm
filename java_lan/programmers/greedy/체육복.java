import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        List<Integer> self = new ArrayList<>();
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    answer++;
                    self.add(lost[i]);
                }
            }
        }
        
        for(int i = 0; i < lost.length; i++) {
            if(self.contains(lost[i])) {
                continue;
            }
            for(int j = 0; j < reserve.length; j++) {
                if(self.contains(reserve[j])) {
                    continue;
                }
                if(reserve[j] - 1 == lost[i] || lost[i] == reserve[j] + 1) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}