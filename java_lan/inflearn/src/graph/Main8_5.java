package graph;

import java.util.*;

public class Main8_5 {

    public int solution(int[][] board, int[] s, int[] e){
        int answer = 0;
        int n = board.length, m = board[0].length;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[][] costs = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));

        for(int i = 0; i < n; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        pq.offer(new int[]{s[0], s[1], 0});
        costs[s[0]][s[1]] = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0], y = now[1], cost = now[2];
            if(cost > costs[x][y]) continue;
            for(int i = 0; i < 4; i++) {
                cost = now[2];
                int nx = x + dx[i];
                int ny = y + dy[i];
                while(0 <= nx && nx < n && 0 <= ny && ny < m && board[nx][ny] == 0) {
                    cost++;
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];
                if(cost < costs[nx][ny]) {
                    costs[nx][ny] = cost;
                    pq.offer(new int[]{nx, ny, cost});
                }
            }
        }

        return (costs[e[0]][e[1]] == Integer.MAX_VALUE) ? -1 : costs[e[0]][e[1]];
    }
    public static void main(String[] args){
        Main8_5 T = new Main8_5();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}
