package simulation_implementation;

import java.util.*;

public class Main1_5 {

    public int solution(int[] nums){
        int answer = 0;
        int[] peaks = {};

        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peaks = Arrays.copyOf(peaks, peaks.length + 1);
                peaks[peaks.length - 1] = i;
            }
        }
        for(int i = 0; i < peaks.length; i++) {
            int count = 1;
            int now = nums[peaks[i]];
            for(int j = peaks[i] - 1; j >= 0; j--) {
                if(now > nums[j]) {
                    count++;
                    now = nums[j];
                } else {
                    break;
                }
            }
            now = peaks[i];
            for(int j = peaks[i] + 1; j < nums.length; j++) {
                if(now > nums[j]) {
                    count++;
                    now = nums[j];
                } else {
                    break;
                }
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }

    public static void main(String[] args){
        Main1_5 T = new Main1_5();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
