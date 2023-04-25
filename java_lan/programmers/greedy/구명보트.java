import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Integer[] arr = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        int lt = 0, rt = arr.length - 1;
        while(lt <= rt) {
            answer++;
            int sum = arr[lt];
            if(sum + arr[rt] <= limit) {
                lt++;
                rt--;
            } else {
                lt++;
            }
        }
        
        return answer;
    }
}