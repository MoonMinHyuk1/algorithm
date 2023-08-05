import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int div = s / n;
        if(div == 0) {
            return new int[]{-1};
        }
        Arrays.fill(answer, div);
        int per = s % n;
        for(int i = answer.length - 1; i >= answer.length - per; i--) {
            answer[i]++;
        }
        
        return answer;
    }
}