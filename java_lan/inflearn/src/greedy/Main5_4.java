package greedy;

import java.util.*;

public class Main5_4 {

    public int solution(int[] plantTime, int[] growTime){
        int answer = 0;
        int n = plantTime.length;
        int[][] flower = new int[n][2];

        for(int i = 0; i < n; i++) {
            flower[i][0] = plantTime[i];
            flower[i][1] = growTime[i];
        }
        Arrays.sort(flower, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int start = 0;
        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, (start + flower[i][0] + flower[i][1]));
            start += flower[i][0];
        }

        return answer;
    }

    public static void main(String[] args){
        Main5_4 T = new Main5_4();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}
