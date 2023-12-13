import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int max = Arrays.stream(arr).max().getAsInt();
        
        while(true) {
            answer += max;
            boolean flag = true;
            for(int n: arr) {
                if(answer % n != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }
        
        return answer;
    }
}