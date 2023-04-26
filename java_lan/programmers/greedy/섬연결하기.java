import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    
    static class Cost implements Comparable<Cost> {
        int a, b, w;
        
        public Cost(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
        
        @Override
        public int compareTo(Cost o) {
            return this.w - o.w;
        }
    }
    
    public void linked(int a) {
        for(Integer v : graph[a]) {
            if(!visited[v]) {
                visited[v] = true;
                linked(v);
            }
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        graph = new ArrayList[n];
        visited = new boolean[n];
        List<Cost> costList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < costs.length; i++) {
            costList.add(new Cost(costs[i][0], costs[i][1], costs[i][2]));
        }
        Collections.sort(costList);
        
        for(Cost cost : costList) {
            Arrays.fill(visited, false);
            linked(cost.a);
            if(!visited[cost.b]) {
                graph[cost.a].add(cost.b);
                graph[cost.b].add(cost.a);
                answer += cost.w;
            }
        }
        
        return answer;
    }
}