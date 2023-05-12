package simulation_implementation;

import java.util.*;

public class Main1_2 {

    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0;
        int now = 0;

        while(k > 0) {
            k--;
            int nx = x + dx[now];
            int ny = y + dy[now];
            if((nx >= 0 && nx < board.length && ny >= 0 && ny < board.length) && board[nx][ny] == 0) {
                x = nx;
                y = ny;
            } else {
                now = (now + 1) % 4;
            }
        }
        answer[0] = x;
        answer[1] = y;

        return answer;
    }

    public static void main(String[] args){
        Main1_2 T = new Main1_2();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
