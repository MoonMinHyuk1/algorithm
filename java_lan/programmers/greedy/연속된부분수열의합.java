import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        int lt = 0, rt = 0;
        int sum = sequence[0], len = Integer.MAX_VALUE;
        while(lt < sequence.length && rt < sequence.length) {
            if(sum < k) {
                rt++;
                if(rt < sequence.length) sum += sequence[rt];
            } else if(sum > k) {
                if(lt < sequence.length) sum -= sequence[lt];
                lt++;
            } else if(sum == k) {
                if(rt - lt < len) {
                    answer = new int[]{lt, rt};
                    len = rt - lt;
                }
                sum -= sequence[lt];
                lt++;
            }
        }
        
//         int[] sum = new int[sequence.length + 1];
        
//         for(int i = 0; i < sequence.length; i++) {
//             sum[i + 1] = sum[i] + sequence[i];
//         }
//         int len = Integer.MAX_VALUE;
//         for(int i = 1; i < sum.length; i++) {
//             for(int j = i - 1; j >= 0; j--) {
//                 if(i - j >= len) break;
//                 if(sum[i] - sum[j] > k) break;
//                 if(sum[i] - sum[j] == k) {
//                     len = i - j;
//                     answer = new int[]{j, i - 1};
//                     break;
//                 }
//             }
//         }
        
        return answer;
    }
}