import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] sum = new int[board.length + 1][board[0].length + 1];
        
        for(int i = 0; i < skill.length; i++) {
            int degree = skill[i][5];
            int x1 = skill[i][1], y1 = skill[i][2];
            int x2 = skill[i][3], y2 = skill[i][4];
            if(skill[i][0] == 1) degree *= -1;
            sum[x1][y1] += degree;
            sum[x1][y2 + 1] += degree * -1;
            sum[x2 + 1][y1] += degree * -1;
            sum[x2 + 1][y2 + 1] += degree;
        }
        for(int i = 0; i < sum.length; i++) {
            for(int j = 1; j < sum[i].length; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }
        for(int i = 0; i < sum[0].length; i++) {
            for(int j = 1; j < sum.length; j++) {
                sum[j][i] += sum[j - 1][i];
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] + sum[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}