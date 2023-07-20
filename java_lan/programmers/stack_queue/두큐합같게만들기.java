import java.util.*;

class Solution {
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1, cnt = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int len = queue1.length;
        long sum1 = 0, sum2 = 0;
        
        for(int i = 0; i < len; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        while(sum1 != sum2 && cnt <= len * 4) {
            if(sum1 < sum2) {
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.offer(q2.poll());
            } else if(sum2 < sum1) {
                sum2 += q1.peek();
                sum1 -= q1.peek();
                q2.offer(q1.poll());
            }
            cnt++;
        }
        answer = (sum1 == sum2) ? cnt : -1;
        
        return answer;
    }
}