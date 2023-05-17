package simulation_implementation;

import java.util.*;

public class Main1_8 {

    public int[] solution(int[] enter, int[] exit){
        int[] answer = new int[enter.length];
        Set<Integer>[] set = new HashSet[answer.length + 1];
        Set<Integer> now = new HashSet<>();
        int exitIndex = 0;

        for(int i = 0; i < set.length; i++) {
            set[i] = new HashSet<>();
        }
        for(int i = 0; i < enter.length; i++) {
            now.add(enter[i]);
            for(int n : now) {
                set[enter[i]].add(n);
                set[n].add(enter[i]);
            }
            while(exitIndex < exit.length && now.contains(exit[exitIndex])) {
                now.remove(exit[exitIndex]);
                exitIndex++;
            }
        }
        for(int i = 1; i < set.length; i++) {
            answer[i - 1] = set[i].size() - 1;
        }

        return answer;
    }

    public static void main(String[] args){
        Main1_8 T = new Main1_8();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
