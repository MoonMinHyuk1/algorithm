import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < operations.length; i++) {
            String[] op = operations[i].split(" ");
            if(op[0].equals("I")) {
                pq.offer(Integer.valueOf(op[1]));
            } else if(op[0].equals("D")) {
                if(!pq.isEmpty() && op[1].equals("1")) {
                    PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
                    while(!pq.isEmpty()) {
                        rpq.offer(pq.poll());
                    }
                    rpq.poll();
                    while(!rpq.isEmpty()) {
                        pq.offer(rpq.poll());
                    }
                } else if(!pq.isEmpty() && op[1].equals("-1")) {
                    pq.poll();
                }
            }
        }
        if(pq.size() == 1) {
            answer[0] = pq.peek();
            answer[1] = pq.poll();
        } else if(pq.size() > 1) {
            answer[1] = pq.poll();
            while(pq.size() != 1) {
                pq.poll();
            }
            answer[0] = pq.poll();
        }
        
        return answer;
    }
}