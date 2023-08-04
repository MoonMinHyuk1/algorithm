import java.util.*;

class Solution {
    
    public int solution(String[] board) {
        int answer = Integer.MAX_VALUE;
        int[] start = new int[2];
        int[] end = new int[2];
        int[][] graph = new int[board.length][board[0].length()];
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                if(board[i].charAt(j) == 'D') graph[i][j] = 1;
                if(board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
                if(board[i].charAt(j) == 'G') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        pq.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0], y = now[1], len = now[2];
            if(x == end[0] && y == end[1]) {
                answer = len;
                break;
            }
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i], cnt = 0;
                while(0 <= nx && nx < graph.length && 0 <= ny && ny < graph[0].length && graph[nx][ny] == 0) {
                    cnt++;
                    nx += dx[i];
                    ny += dy[i];
                }
                if(cnt > 0) {
                    nx -= dx[i];
                    ny -= dy[i];
                    if(!visited[nx][ny]) {
                        pq.offer(new int[]{nx, ny, len + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        answer = (answer == Integer.MAX_VALUE) ? -1 : answer;
        
        return answer;
    }
}