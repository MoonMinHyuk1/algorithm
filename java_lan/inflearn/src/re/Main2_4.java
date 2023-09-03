package re;

import java.util.*;

public class Main2_4 {

    public int solution(int[] nums, int m){
        int answer = 0;
        int[] sum = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();

        sum[0] = nums[0];
        for(int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        map.put(0, 1);
        for(int i = 0; i < sum.length; i++) {
            if(map.containsKey(sum[i] - m)) {
                answer += map.get(sum[i] - m);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args){
        Main2_4 T = new Main2_4();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
