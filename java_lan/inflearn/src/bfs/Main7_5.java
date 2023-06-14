package bfs;

import java.util.*;

public class Main7_5 {

    public int bfs(int[][] board) {
        int min = Integer.MAX_VALUE;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[][] dist = new int[board.length][board.length];
        Queue<int[]> queue = new LinkedList<>();
        int building = 0;
        int[][] ground = new int[board.length][board.length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] != 1) continue;
                building++;
                boolean[][] visited = new boolean[board.length][board.length];
                queue.offer(new int[]{i, j});
                visited[i][j] = true;
                int level = 0;
                while(!queue.isEmpty()) {
                    level++;
                    int size = queue.size();
                    for(int k = 0; k < size; k++) {
                        int[] now = queue.poll();
                        for(int l = 0; l < 4; l++) {
                            int nx = now[0] + dx[l];
                            int ny = now[1] + dy[l];
                            if(0 <= nx && nx < board.length && 0 <= ny && ny < board.length && !visited[nx][ny] && board[nx][ny] == 0) {
                                visited[nx][ny] = true;
                                dist[nx][ny] += level;
                                queue.offer(new int[]{nx, ny});
                                ground[nx][ny]++;
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == 0 && ground[i][j] == building) {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    public int solution(int[][] board){
        int answer = 0;

        answer = bfs(board);

        return answer;
    }

    public static void main(String[] args){
        Main7_5 T = new Main7_5();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
