import java.util.*;

class Solution {
    static int answer, n, m, cnt;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    //시간초과
    public void dfs(int x, int y) {
        if(x == n - 1 && y == m - 1) {
            answer = (answer > cnt) ? cnt : answer;
            
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == 1) {
                cnt++;
                visited[nx][ny] = 0;
                dfs(nx, ny);
                visited[nx][ny] = 1;
                cnt--;
            }
        }
    }
    
    public void bfs() {
        Queue<Index> queue = new LinkedList<>();
        boolean ch = false;
        
        queue.offer(new Index(0, 0));
        while(!queue.isEmpty()) {
            answer++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Index now = queue.poll();
                if(now.x == n - 1 && now.y == m - 1) {
                    ch = true;
                    queue.clear();
                    break;
                }
                for(int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == 1) {
                        visited[nx][ny] = 0;
                        queue.offer(new Index(nx, ny));
                    }
                }
            }
        }
        if(!ch) {
            answer = -1;
        }
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = maps;
        visited[0][0] = 0;
        
        // answer = Integer.MAX_VALUE;
        // cnt = 1;
        // dfs(0, 0);
        // if(answer == Integer.MAX_VALUE) {
        //     answer = -1;
        // }
        
        answer = 0;
        bfs();
        
        return answer;
    }
    
    static class Index {
        int x;
        int y;
        
        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}