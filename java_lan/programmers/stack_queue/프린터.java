import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int num : priorities) {
            queue.offer(num);
        }
        while(!queue.isEmpty()) {
            int now = queue.poll();
            boolean ch = true;
            for(int num : queue) {
                if(num > now) {
                    ch = false;
                    queue.offer(now);
                    break;
                }
            }
            location--;
            if(ch && location == -1) {
                answer = priorities.length - queue.size();
                queue.clear();
            } else if(!ch && location == -1) {
                location = queue.size() - 1;
            }
        }
        
        return answer;
    }
}