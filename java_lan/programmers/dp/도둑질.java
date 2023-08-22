import java.util.*;

class Solution {
    
    public int findMax(int[] arr) {
        int[] dp = new int[arr.length + 2];
        
        for(int i = 0; i < arr.length; i++) {
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + arr[i]);
        }
        
        return dp[dp.length - 1];
    }
    
    public int solution(int sticker[]) {
        int answer = 0;
        
        int first = findMax(Arrays.copyOfRange(sticker, 0, sticker.length - 1));
        int last = findMax(Arrays.copyOfRange(sticker, 1, sticker.length));
        answer = Math.max(first, last);

        return answer;
    }
}