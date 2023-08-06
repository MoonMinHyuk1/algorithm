import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int i1 = 0, i2 = 0;
        while(i1 < A.length && i2 < B.length) {
            if(A[i1] >= B[i2]) {
                i2++;
            } else {
                answer++;
                i1++;
                i2++;
            }
        }
        
        return answer;
    }
}