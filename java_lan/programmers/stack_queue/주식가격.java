import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 0; i < prices.length; i++) {
            while(!deque.isEmpty() && (prices[deque.peekLast()] > prices[i])) {
                int index = deque.pollLast();
                answer[index] = i - index;
            }
            deque.offer(i);
        }
        for(int i = 0; i < answer.length; i++) {
            if(answer[i] == 0) {
                answer[i] = answer.length - i - 1;
            }
        }
        
        return answer;
    }
}