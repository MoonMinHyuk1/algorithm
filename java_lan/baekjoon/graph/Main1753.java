package java_lan.baekjoon.graph;

import java.util.*;
import java.io.*;

public class Main1753 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine()) - 1;
        List<List<int[]>> graph = new ArrayList<>();
        int[] cost = new int[v];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));

        for(int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph.get(Integer.parseInt(st.nextToken()) - 1).add(new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())});
        }
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[k] = 0;
        pq.offer(new int[]{k, 0});
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int u = now[0], sum = now[1];
            for(int[] next: graph.get(u)) {
                if(sum + next[1] < cost[next[0]]) {
                    cost[next[0]] = sum + next[1];
                    pq.offer(new int[]{next[0], cost[next[0]]});
                }
            }
        }
        for(int i = 0; i < cost.length; i++) {
            System.out.println((cost[i] == Integer.MAX_VALUE) ? "INF" : cost[i]);
        }
    }
}
