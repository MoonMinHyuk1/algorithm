package re;

import java.util.*;

public class Main4_1 {

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> ((o1[1] == o2[1]) ? (o1[0] - o2[0]) : (o1[1] - o2[1])));

        for(int i = 0; i < nums.length; i++) {
            int n = nums[i], cnt = 0;
            while(n > 0) {
                if(n % 2 == 1) cnt++;
                n /= 2;
            }
            pq.offer(new int[]{nums[i], cnt});
        }
        int index = 0;
        while(!pq.isEmpty()) {
            answer[index++] = pq.poll()[0];
        }

        return answer;
    }

    public static void main(String[] args){
        Main4_1 T = new Main4_1();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
