package java_lan.baekjoon.graph;

import java.util.*;
import java.io.*;

public class Main1916 {

    public static int solution(List<List<int[]>> graph, int a, int b) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        int[] cost = new int[graph.size()];

        Arrays.fill(cost, 100000000);
        cost[a] = 0;
        pq.offer(new int[]{a, 0});
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(now[0] == b) {
                return now[1];
            }
            for(int[] next: graph.get(now[0])) {
                if(cost[next[0]] > now[1] + next[1]) {
                    pq.offer(new int[]{next[0], now[1] + next[1]});
                    cost[next[0]] = now[1] + next[1];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, c});
        }
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        int answer = solution(graph, a, b);
        System.out.println(answer);
    }
}
