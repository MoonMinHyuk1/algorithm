import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    
    public int bfs() {
        Deque<Integer> deque = new ArrayDeque<>();
        int len = 0;
        
        deque.offer(0);
        visited[0] = true;
        while(!deque.isEmpty()) {
            int size = deque.size();
            len = size;
            for(int i = 0; i < size; i++) {
                int v = deque.poll();
                for(int n : graph[v]) {
                    if(!visited[n]) {
                        visited[n] = true;
                        deque.offer(n);
                    }
                }
            }
        }
        
        return len;
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n];
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++) {
            int a = edge[i][0] - 1;
            int b = edge[i][1] - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        answer = bfs();
        
        return answer;
    }
}