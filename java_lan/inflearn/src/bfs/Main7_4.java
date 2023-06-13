package bfs;

import java.util.*;

public class Main7_4 {

    public int bfs(int[][] board) {
        int cnt = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean[][] visited = new boolean[board.length][board.length];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] now = queue.poll();
                if(now[0] == board.length - 1 && now[1] == board.length - 1) {
                    return cnt;
                }
                for(int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if(0 <= nx && nx < board.length && 0 <= ny && ny < board.length && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            cnt++;
        }

        return -1;
    }

    public int solution(int[][] board){
        int answer = 0;

        answer = bfs(board);

        return answer;
    }

    public static void main(String[] args){
        Main7_4 T = new Main7_4();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}
