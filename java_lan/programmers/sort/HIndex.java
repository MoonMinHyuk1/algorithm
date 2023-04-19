import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = -1;
        
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        for(int n = arr[0]; n >= 0; n--) {
            for(int i = 0; i < arr.length; i++) {
                if(n == arr[i]) {
                    if(((arr.length - i - 1) <= n) && (n <= i + 1)) {
                        answer = n;
                    }
                }
                if(n > arr[i]) {
                    if(((arr.length - i) <= n) && (n <= i)) {
                        answer = n;
                    }
                    break;
                }
            }
            if(answer != -1) {
                break;
            }
            if(n == 0 && answer == -1) {
                answer = arr.length;
            }
        }
        
        return answer;
    }
}