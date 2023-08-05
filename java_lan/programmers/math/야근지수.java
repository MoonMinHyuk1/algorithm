import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        while(n != 0 && !pq.isEmpty()) {
            int num = pq.poll() - 1;
            if(num != 0) {
                pq.offer(num);
            }
            n--;
        }
        while(!pq.isEmpty()) {
            int num = pq.poll();
            answer += (num * num);
        }
        
        return answer;
    }
}