import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 0; i < moves.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][moves[i] - 1] == 0) continue;
                if(!deque.isEmpty() && deque.peekLast() == board[j][moves[i] - 1]) {
                    answer += 2;
                    deque.pollLast();
                } else {
                    deque.offer(board[j][moves[i] - 1]);
                }
                board[j][moves[i] - 1] = 0;
                break;
            }
        }
        
        return answer;
    }
}