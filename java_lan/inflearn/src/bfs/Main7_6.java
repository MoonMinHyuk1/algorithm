package bfs;

import java.util.*;

public class Main7_6 {

    public int bfs(int[][] board, int r, int c) {
        int min = Integer.MAX_VALUE;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[r][c];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] != 2 && board[i][j] != 3) continue;
                boolean[][] visited = new boolean[r][c];
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
                            if(0 <= nx && nx < r && 0 <= ny && ny < c && !visited[nx][ny] && board[nx][ny] != 1) {
                                visited[nx][ny] = true;
                                dist[nx][ny] += level;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] == 4) {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }

        return min;
    }

    public int solution(int[][] board){
        int answer = 0;
        int r = board.length, c = board[0].length;

        answer = bfs(board, r, c);

        return answer;
    }

    public static void main(String[] args){
        Main7_6 T = new Main7_6();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}
