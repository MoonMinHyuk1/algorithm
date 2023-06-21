import java.util.*;

class Solution {
    
    public int getDivisor(int n) {
        int cnt = 0;
        int sqrt = (int) Math.sqrt(n);
        
        for(int i = 1; i <= sqrt; i++) {
            if(n % i == 0) {
                cnt++;
                if(i * i != n) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++) {
            int cnt = getDivisor(i);
            answer += (cnt > limit) ? power : cnt;
        }
        
        return answer;
    }
}