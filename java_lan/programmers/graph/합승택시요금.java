import java.util.*;

class Solution {
    
    int answer;
    List<List<int[]>> graph;
    
    public int minPath(int s, int e) {
        int[] cost = new int[graph.size()];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        
        Arrays.fill(cost, Integer.MAX_VALUE);
        pq.offer(new int[]{s, 0});
        cost[s] = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(now[0] == e) {
                return now[1];
            }
            for(int[] next: graph.get(now[0])) {
                if(now[1] + next[1] < cost[next[0]]) {
                    cost[next[0]] = now[1] + next[1];
                    pq.offer(new int[]{next[0], cost[next[0]]});
                }
            }
        }
        
        return -1;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < fares.length; i++) {
            graph.get(fares[i][0] - 1).add(new int[]{fares[i][1] - 1, fares[i][2]});
            graph.get(fares[i][1] - 1).add(new int[]{fares[i][0] - 1, fares[i][2]});
        }
        for(int i = 0; i < n; i++) {
            int toa = minPath(i, a - 1);
            int tob = minPath(i, b - 1);
            int tos = minPath(i, s - 1);
            if(toa == -1 || tob == -1 || tos == -1) continue;
            int sum = toa + tob + tos;
            answer = Math.min(answer, sum);
        }
        
        return answer;
    }
}