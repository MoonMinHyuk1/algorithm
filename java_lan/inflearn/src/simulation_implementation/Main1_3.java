package simulation_implementation;

import java.util.*;

public class Main1_3 {

    public int solution(int[][] board){
        int answer = 0;
        int[] man = new int[2];
        int[] dog = new int[2];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int dMan = 0, dDog = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 2) {
                    man[0] = i;
                    man[1] = j;
                } else if(board[i][j] == 3) {
                    dog[0] = i;
                    dog[1] = j;
                }
            }
        }
        while(!(man[0] == dog[0] && man[1] == dog[1])) {
            answer++;
            if(answer > 10000) {
                answer = 0;
                break;
            }

            int nx = man[0] + dx[dMan];
            int ny = man[1] + dy[dMan];
            if((nx >= 0 && nx < board.length && ny >= 0 && ny < board.length) && board[nx][ny] != 1) {
                man[0] = nx;
                man[1] = ny;
            } else {
                dMan = (++dMan) % 4;
            }

            nx = dog[0] + dx[dDog];
            ny = dog[1] + dy[dDog];
            if((nx >= 0 && nx < board.length && ny >= 0 && ny < board.length) && board[nx][ny] != 1) {
                dog[0] = nx;
                dog[1] = ny;
            } else {
                dDog = (++dDog) % 4;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main1_3 T = new Main1_3();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
