import java.util.*;

class Solution {
    
    public boolean collect(int distance, int[] rocks, int n) {
        int prev = rocks[0], sum = 0;
        for(int i = 1; i < rocks.length; i++) {
            if(rocks[i] - prev < distance) {
                sum++;
            } else {
                prev = rocks[i];
            }
        }
        return (sum <= n) ? true : false;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        int[] arr = Arrays.copyOf(rocks, rocks.length + 2);
        arr[arr.length - 2] = 0;
        arr[arr.length - 1] = distance;
        Arrays.sort(arr);
        int lt = 0, rt = distance;
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(collect(mid, arr, n)) {
                lt = mid + 1;
                answer = mid;
            } else {
                rt = mid - 1;
            }
        }
        
        return answer;
    }
}