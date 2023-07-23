import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] graph = new int[N][N];
        int[] dis = new int[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        for(int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        for(int i = 0; i < road.length; i++) {
            int a = road[i][0] - 1;
            int b = road[i][1] - 1;
            int c = road[i][2];
            graph[a][b] = Math.min(graph[a][b], c);
            graph[b][a] = Math.min(graph[b][a], c);
        }
        for(int i = 0; i < graph[0].length; i++) {
            if(graph[0][i] != Integer.MAX_VALUE)
                pq.offer(new int[]{0, i, graph[0][i]});
        }
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(dis[now[0]] + now[2] < dis[now[1]]) {
                dis[now[1]] = dis[now[0]] + now[2];
                for(int i = 0; i < graph[now[1]].length; i++) {
                    if(graph[now[1]][i] != Integer.MAX_VALUE)
                        pq.offer(new int[]{now[1], i, graph[now[1]][i]});
                }
            }
        }
        for(int i = 0; i < dis.length; i++) {
            if(dis[i] <= K) answer++;
        }

        return answer;
    }
}