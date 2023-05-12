package simulation_implementation;

import java.util.*;

public class Main1_4 {

    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];

        if(k > c * r) {
            return answer;
        }

        int[][] board = new int[r][c];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = r - 1, y = 0, d = 0;

        while(k > 1) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if((nx >= 0 && nx < r && ny >= 0 && ny < c) && board[nx][ny] == 0) {
                k--;
                board[x][y] = 1;
                x = nx;
                y = ny;
            } else {
                d = (++d) % 4;
            }
        }
        answer[0] = y + 1;
        answer[1] = r - x;

        return answer;
    }

    public static void main(String[] args){
        Main1_4 T = new Main1_4();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
