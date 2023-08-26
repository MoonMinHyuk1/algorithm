import java.math.*;

class Solution {
    
    public int gcd(int w, int h) {
        int min = Math.min(w, h);
        int max = Math.max(w, h);
        int sqrt = (int) Math.sqrt(min);
        int gcd = 0;
        
        for(int i = 1; i <= sqrt; i++) {
            if(min % i == 0) {
                if(max % i == 0) gcd = Math.max(gcd, i);
                if(max % (min / i) == 0) gcd = Math.max(gcd, (min / i));
            }
        }
        
        return gcd;
    }
    
    public long solution(int w, int h) {
        long answer = (long) w * (long) h;
        
        // int gcd = gcd(w, h);
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        int nw = w / gcd;
        int nh = h / gcd;
        answer -= gcd * (((long) nw * (long) nh) - ((long) nw - 1) * ((long) nh - 1));
        
        return answer;
    }
}