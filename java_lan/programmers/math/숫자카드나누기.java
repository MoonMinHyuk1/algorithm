import java.util.*;

class Solution {
    
    public Set<Integer> sqrt(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int s = (int) Math.sqrt(arr[0]);
        
        for(int i = 1; i <= s; i++) {
            if(arr[0] % i == 0) {
                boolean small = true, big = true;
                for(int j = 1; j < arr.length; j++) {
                    if(arr[j] % i != 0) small = false;
                    if(arr[j] % (arr[0] / i) != 0) big = false;
                }
                if(small) set.add(i);
                if(big) set.add(arr[0] / i);
            }
        }
        
        return set;
    }
    
    public int findNum(int[] arr1, int[] arr2) {
        int result = 0;
        
        Arrays.sort(arr1);
        Set<Integer> set = sqrt(arr1);
        for(int num: set) {
            boolean flag = true;
            for(int i = 0; i < arr2.length; i++) {
                if(arr2[i] % num == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                result = Math.max(result, num);
            }
        }
        
        return result;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        answer = findNum(arrayA, arrayB);
        answer = Math.max(answer, findNum(arrayB, arrayA));
        
        return answer;
    }
}