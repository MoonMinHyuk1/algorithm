import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][][] visited = new int[4][n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < visited[i].length; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
                visited[i][0][0] = 0;
            }
        }
        if(board[1][0] == 0) {
            visited[0][1][0] = 100;
            pq.offer(new int[]{1, 0, 100, 0});
        }
        if(board[0][1] == 0) {
            visited[1][0][1] = 100;
            pq.offer(new int[]{0, 1, 100, 1});
        }
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0], y = now[1], sum = now[2];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < n && board[nx][ny] == 0) {
                    int nsum = sum + 100;
                    if(now[3] != i) {
                        nsum += 500;
                    }
                    if(nsum <= visited[i][nx][ny]) {
                        visited[i][nx][ny] = nsum;
                        pq.offer(new int[]{nx, ny, nsum, i});
                    }
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            answer = Math.min(answer, visited[i][n - 1][n - 1]);
        }
        
        return answer;
    }
}