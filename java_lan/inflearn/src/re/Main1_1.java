package re;

import java.util.Arrays;

public class Main1_1 {

    public char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];
        int[] num = new int[n];

        for(int i = 0; i < num.length; i++) {
            num[i] = i + 1;
        }
        for(int i = 0; i < ladder.length; i++) {
            for(int j = 0; j < ladder[i].length; j++) {
                int index = ladder[i][j];
                int tmp = num[index];
                num[index] = num[index - 1];
                num[index - 1] = tmp;
            }
        }
        for(int i = 0; i < num.length; i++) {
            answer[i] = (char) ('A' + num[i] - 1);
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
