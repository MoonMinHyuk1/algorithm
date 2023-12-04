import java.util.*;

class Solution {
    
    public boolean isPrime(long n) {
        long sqrt = (long) Math.sqrt(n);
        int cnt = 0;
        
        if(n == 1) {
            return false;
        }
        if(n == 2) {
            return true;
        }
        for(long i = 2; i <= sqrt; i++) {
            if(n % i == 0) {
                cnt++;
            }
        }
        
        return (cnt == 0) ? true : false;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String str = Integer.toString(n, k);
        String[] arr = str.split("0");
        for(String s: arr) {
            if(s.equals("")) continue;
            if(isPrime(Long.valueOf(s))) {
                answer++;
            }
        }
        
        return answer;
    }
}