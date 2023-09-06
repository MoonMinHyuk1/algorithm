package re;

import java.util.*;

public class Main7_6 {

    int[][][] dis;

    public void bfs(int[][] board, int i, int j) {
        int r = board.length, c = board[0].length;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
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
                    if(nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] != 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        if(board[nx][ny] == 4) {
                            dis[nx][ny][0] += level;
                            dis[nx][ny][1]++;
                        }
                    }
                }
            }
        }
    }

    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;

        dis = new int[board.length][board[0].length][2];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 2 || board[i][j] == 3) {
                    bfs(board, i, j);
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(dis[i][j][1] == 2) {
                    answer = Math.min(answer, dis[i][j][0]);
                }
            }
        }

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
