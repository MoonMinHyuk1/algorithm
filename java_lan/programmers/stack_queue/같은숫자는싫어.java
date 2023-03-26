import java.util.*;

class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Deque<Integer> deque = new ArrayDeque<>();
        
        Arrays.stream(arr).forEach(n -> {
            if(deque.isEmpty()) {
                deque.offer(n);
            }
            else if(deque.peekLast() != n) {
                deque.offer(n);
            }
        });
        answer = new int[deque.size()];
        int i = 0;
        while(!deque.isEmpty()) {
            answer[i++] = deque.poll();
        }

        return answer;
    }
}