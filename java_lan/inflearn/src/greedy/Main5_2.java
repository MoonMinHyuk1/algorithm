package greedy;

import java.util.*;

public class Main5_2 {

    public int solution(int[] nums){
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        Arrays.sort(nums);
        for(int n: nums) {
            deque.offer(n);
        }
        while(!deque.isEmpty()) {
            answer++;
            int heavy = deque.pollLast();
            while(!deque.isEmpty() && (deque.peekFirst() + heavy <= 5)) {
                deque.pollFirst();
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main5_2 T = new Main5_2();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
