import java.util.*;

class Solution {
    
    int[] dx = {1, 0, 1};
    int[] dy = {0, 1, 1};
    
    public int bfs(int[][] board, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int level = 1;
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = true;
            for(int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for(int j = 0; j < 3; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if(0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length && board[nx][ny] == 1) {
                        if(!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    } else {
                        return level * level;
                    }
                }
            }
            level++;
        }
        
        return level * level;
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        
        if(board[0][0] == 1 || board[0][1] == 1 || board[1][0] == 1) answer = 1;
        for(int i = 1; i < board.length; i++) {
            for(int j = 1; j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    // answer = Math.max(answer, bfs(board, i, j));
                    board[i][j] = Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1])) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }
        answer *= answer;

        return answer;
    }
}