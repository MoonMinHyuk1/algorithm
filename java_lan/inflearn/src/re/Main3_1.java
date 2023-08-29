package re;

import java.util.*;

public class Main3_1 {

    public int solution(int[] nums){
        int answer = 0;
        Set<Integer> set = new TreeSet<>();
        Set<Integer> duplication = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for(int num: set) {
            if(duplication.contains(num)) continue;
            int n = num, cnt = 1;
            duplication.add(n);
            while(set.contains(n + 1)) {
                n++;
                cnt++;
                duplication.add(n);
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        Main3_1 T = new Main3_1();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
