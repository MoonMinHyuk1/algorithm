package graph;

import java.util.*;

public class Main8_2 {

    public int solution(int[][] routes, int s, int e){
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> starts = new ArrayList<>();

        for(int i = 0; i < routes.length; i++) {
            graph.add(new ArrayList<>());
            for(int j = 0; j < routes[i].length; j++) {
                graph.get(i).add(routes[i][j]);
                if(routes[i][j] == s) {
                    starts.add(i);
                }
            }
        }
        for(int start: starts) {
            boolean[] visited = new boolean[routes.length];
            Queue<Integer> queue = new LinkedList<>();

            visited[start] = true;
            queue.offer(start);
            int level = 0;
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    int now = queue.poll();
                    if(graph.get(now).contains(e)) {
                        answer = Math.min(answer, level);
                        queue.clear();
                        break;
                    }
                    for(int route: graph.get(now)) {
                        for(int j = 0; j < graph.size(); j++) {
                            if(graph.get(j).contains(route) && !visited[j]) {
                                visited[j] = true;
                                queue.offer(j);
                            }
                        }
                    }
                }
                level++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main8_2 T = new Main8_2();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
