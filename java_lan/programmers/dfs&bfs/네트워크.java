import java.util.*;

class Solution {
    boolean[] visited = {};
    
    public void dfs(int v, int n, int[][] computers) {
        for(int i = 0; i < n; i++) {
            if(computers[v][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, n, computers);
            }
        }
    }
    
    public void bfs(int v, int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(v);
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i = 0; i < n; i++) {
                if(computers[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                // dfs(i, n, computers);
                bfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
}