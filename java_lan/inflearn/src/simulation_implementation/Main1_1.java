package simulation_implementation;

import java.util.*;

public class Main1_1 {

    public char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];

        for(int i = 0; i < answer.length; i++) {
            int now = i + 1;
            for(int j = ladder.length - 1; j >= 0; j--) {
                for(int num : ladder[j]) {
                    if(now == num) {
                        now++;
                        break;
                    } else if(now == num + 1) {
                        now--;
                        break;
                    }
                }
            }
            answer[i] = (char) ('A' + now - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main1_1 T = new Main1_1();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
