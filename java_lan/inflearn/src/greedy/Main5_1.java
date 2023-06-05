package greedy;

import java.util.*;

public class Main5_1 {

    public int solution(int[] nums, int m){
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        Arrays.sort(nums);
        for(int n: nums) {
            deque.offer(n);
        }
        while(!deque.isEmpty()) {
            if(deque.peekFirst() + deque.peekLast() <= m) {
                deque.pollFirst();
            }
            deque.pollLast();
            answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        Main5_1 T = new Main5_1();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}
