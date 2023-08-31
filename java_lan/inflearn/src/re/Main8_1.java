package re;

import java.util.*;

public class Main8_1 {

    public int solution(int n, int[][] flights, int s, int e, int k){
        int answer = 0;
        List<List<int[]>> graph = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int[] cost = new int[n];

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < flights.length; i++) {
            graph.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[s] = 0;
        queue.offer(new int[]{s, 0});
        int cnt = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for(int[] flight: graph.get(now[0])) {
                    int ni = flight[0];
                    int nc = now[1] + flight[1];
                    if(nc < cost[ni]) {
                        cost[ni] = nc;
                        queue.offer(new int[]{ni, nc});
                    }
                }
            }
            if(cnt == k) break;
            cnt++;
        }

        return (cost[e] == Integer.MAX_VALUE) ? -1 : cost[e];
    }

    public static void main(String[] args){
        Main8_1 T = new Main8_1();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}
