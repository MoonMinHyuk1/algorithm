package sorting_thinking;

import java.util.*;

public class Main4_7 {

    public int solution(int[][] meetings){
        int answer = 0;

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(int i = 0; i < meetings.length; i++) {
            int end = meetings[i][1];
            int cnt = 1;
            for(int j = i + 1; j < meetings.length; j++) {
                if(meetings[j][0] < end) {
                    cnt++;
                } else {
                    break;
                }
            }
            answer = Math.max(answer, cnt);
            i += cnt;
        }

        return answer;
    }

    public static void main(String[] args){
        Main4_7 T = new Main4_7();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
