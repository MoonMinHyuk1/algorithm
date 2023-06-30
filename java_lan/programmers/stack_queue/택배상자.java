import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 1; i <= order.length; i++) {
            queue.offer(i);
        }
        for(int i = 0; i < order.length; i++) {
            boolean stop = true;
            if(!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                answer++;
                stop = false;
            } else {
                while(!queue.isEmpty()) {
                    if(queue.peek() == order[i]) {
                        queue.poll();
                        answer++;
                        stop = false;
                        break;
                    } else {
                        stack.push(queue.poll());
                    }
                }
            }
            if(stop) {
                break;
            }
        }
        
        return answer;
    }
}