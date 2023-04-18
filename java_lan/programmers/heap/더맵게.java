import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int n: scoville) {
            pq.offer(n);
        }
        while(!pq.isEmpty()) {
            int n1 = pq.poll();
            if(n1 >= K) {
                return answer;
            }
            if(pq.isEmpty() && n1 < K) {
                answer = -1;
                break;
            }
            int n2 = pq.poll();
            int num = n1 + n2 * 2;
            pq.offer(num);
            answer++;
        }
        
        return answer;
    }
}