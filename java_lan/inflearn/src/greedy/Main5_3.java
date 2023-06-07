package greedy;

import java.util.*;

public class Main5_3 {

    public int solution(int n, int[] nums){
        int answer = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) continue;
            int max = 0, maxIndex = -1;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] >= max && j - nums[j] <= i && i <= j + nums[j]) {
                    max = nums[j];
                    maxIndex = j;
                }
            }
            if(maxIndex == -1) {
                return -1;
            } else {
                i = maxIndex + nums[maxIndex];
                answer++;
            }
        }

        return answer;
    }

    public int refactor(int n, int[] nums){
        int answer = 0;
        int[][] line = new int[nums.length + 1][2];

        for(int i = 0; i < nums.length; i++) {
            line[i][0] = Math.max(0, i - nums[i]);
            line[i][1] = Math.min(n, i + nums[i]);
        }
        Arrays.sort(line, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int start = 0, end = 0, i = 0;
        while(i < line.length) {
            while(i < line.length && line[i][0] <= start) {
                end = Math.max(end, line[i][1]);
                i++;
            }
            answer++;
            if(end == n) {
                break;
            }
            if(start == end) {
                answer = -1;
                break;
            }
            start = end;
        }

        return answer;
    }

    public static void main(String[] args){
        Main5_3 T = new Main5_3();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
        System.out.println(T.refactor(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.refactor(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.refactor(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.refactor(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
