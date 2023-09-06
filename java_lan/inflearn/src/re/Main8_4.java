package re;

import java.util.*;

public class Main8_4 {

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length, m = board[0].length;
        int[] dx = {0, 0, 0, 1, -1};
        int[] dy = {0, 1, -1, 0, 0};
        int[][] cost = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));

        for(int i = 0; i < cost.length; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0], y = now[1];
            for(int i = 1; i < 5; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nc = now[2];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(board[x][y] != i) {
                        nc++;
                    }
                    if(nc < cost[nx][ny]) {
                        cost[nx][ny] = nc;
                        pq.offer(new int[]{nx, ny, nc});
                    }
                }
            }
        }

        return cost[n - 1][m - 1];
    }

    public static void main(String[] args){
        Main8_4 T = new Main8_4();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}
