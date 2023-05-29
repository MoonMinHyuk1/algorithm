package sorting_thinking;

import java.util.*;

public class Main4_2 {

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        boolean[] ch = new boolean[nums.length];
        int index = 0;

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(!ch[i]) {
                ch[i] = true;
                answer[index++] = nums[i];
                int n = nums[i] * 2;
                for(int j = i + 1; j < nums.length; j++) {
                    if(nums[j] == n) {
                        ch[j] = true;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main4_2 T = new Main4_2();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
