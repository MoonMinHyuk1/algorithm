package sorting_thinking;

import java.util.*;

public class Main4_3 {

    public int solution(int[] nums, int k){
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i = 0; i < nums.length; i += 2) {
            if(pq.size() < k) {
                pq.offer(arr[i] - arr[i + 1]);
            } else {
                if(pq.peek() < (arr[i] - arr[i + 1])) {
                    pq.poll();
                    pq.offer(arr[i] - arr[i + 1]);
                }
            }
            answer += arr[i + 1];
        }
        while(!pq.isEmpty()) {
            answer += pq.poll();
        }

        return answer;
    }

    public static void main(String[] args){
        Main4_3 T = new Main4_3();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}
