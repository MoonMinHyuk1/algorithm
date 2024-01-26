import java.util.*;

class Solution {
    int answer;
    List<List<Integer>> graph;
    
    public void dfs(int[] info, int v, int sheep, int wolf, List<Integer> path) {
        if(info[v] == 0) sheep++;
        else wolf++;
        if(wolf >= sheep) return;
        
        answer = Math.max(answer, sheep);
        List<Integer> next = new ArrayList<>(path);
        if(!graph.get(v).isEmpty()) {
            next.addAll(graph.get(v));
        }
        next.remove(Integer.valueOf(v));
        for(int nv: next) {
            dfs(info, nv, sheep, wolf, next);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        graph = new ArrayList<>();
        for(int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        dfs(info, 0, 0, 0, new ArrayList<>(0));
        
        return answer;
    }
}