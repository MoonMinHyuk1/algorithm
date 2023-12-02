import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int num = 0;
        
        while(sb1.length() < t * m) {
            sb1.append(Integer.toString(num++, n).toUpperCase());
        }
        String str = sb1.toString();
        for(int i = p; i <= t * m; i += m) {
            sb2.append(str.charAt(i - 1));
        }
        answer = sb2.toString();
        
        return answer;
    }
}