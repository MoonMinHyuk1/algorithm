import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> speed = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++) {
            deque.offer(progresses[i]);
            speed.offer(speeds[i]);
        }
        while(!deque.isEmpty()) {
            int size = deque.size();
            int cnt = 0;
            for(int i = 0; i < size; i++) {
                int p = deque.poll();
                int s = speed.poll();
                deque.offer(p + s);
                speed.offer(s);
            }
            while(!deque.isEmpty() && deque.peek() >= 100) {
                cnt++;
                deque.poll();
                speed.poll();
            }
            if(cnt != 0) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = cnt;
            }
        }
        
        return answer;
    }
}