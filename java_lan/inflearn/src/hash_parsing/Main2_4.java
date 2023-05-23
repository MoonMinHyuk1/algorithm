package hash_parsing;

import java.util.*;

public class Main2_4 {

    public int solution(int[] nums, int m){
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        map.put(0, 1);
        for(int n : nums) {
            sum += n;
            answer += map.getOrDefault(sum - m, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
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
