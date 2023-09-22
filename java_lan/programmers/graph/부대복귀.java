import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>> graph = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        int[] cost = new int[n + 1];
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        Arrays.fill(cost, Integer.MAX_VALUE);
        pq.offer(new int[]{destination, 0});
        cost[destination] = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int i = now[0], c = now[1];
            for(int ni: graph.get(i)) {
                int nc = c + 1;
                if(nc < cost[ni]) {
                    pq.offer(new int[]{ni, nc});
                    cost[ni] = nc;
                }
            }
        }
        for(int i = 0; i < sources.length; i++) {
            answer[i] = (cost[sources[i]] == Integer.MAX_VALUE) ? -1 : cost[sources[i]];
        }
        
        return answer;
    }
}