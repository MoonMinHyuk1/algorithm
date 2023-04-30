import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    int cnt;
    
    public void search(int v) {
        for(int n : graph[v]) {
            if(!visited[n]) {
                cnt++;
                visited[n] = true;
                search(n);
            }
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList[n];
        
        for(int i = 0; i < wires.length; i++) {
            for(int j = 0; j < n; j++) {
                graph[j] = new ArrayList<>();
            }
            for(int j = 0; j < wires.length; j++) {
                if(i == j) continue;
                int a = wires[j][0] - 1;
                int b = wires[j][1] - 1;
                graph[a].add(b);
                graph[b].add(a);
            }
            visited = new boolean[n];
            visited[0] = true;
            cnt = 1;
            search(0);
            answer = Math.min(answer, Math.abs(n - (2 * cnt)));
        }
        
        return answer;
    }
}