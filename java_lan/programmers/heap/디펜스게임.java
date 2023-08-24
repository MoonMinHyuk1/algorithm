import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int sum = 0;
        for(int i = 0; i < enemy.length; i++) {
            if(pq.size() < k) {
                pq.offer(enemy[i]);
            } else {
                if(pq.peek() < enemy[i]) {
                    sum += pq.poll();
                    pq.offer(enemy[i]);
                } else {
                    sum += enemy[i];
                }
                if(sum > n) {
                    answer = i;
                    break;
                }
            }
        }
        if(answer == 0) {
            answer = enemy.length;
        }
        
        return answer;
    }
}