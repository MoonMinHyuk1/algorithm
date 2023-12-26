import java.util.*;

class Solution {
    
    boolean[][] visited;
    PriorityQueue<Integer> pq;
    
    public void bfs(int m, int n, int[][] picture, int i, int j) {
        int sum = 1, num = picture[i][j];
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && picture[nx][ny] == num && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    sum++;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        pq.offer(sum);
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        visited = new boolean[m][n];
        pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !visited[i][j]) {
                    bfs(m, n, picture, i, j);
                }
            }
        }
        answer[0] = pq.size();
        answer[1] = pq.peek();
        
        return answer;
    }
}