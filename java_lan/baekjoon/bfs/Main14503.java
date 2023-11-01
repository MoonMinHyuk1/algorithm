package java_lan.baekjoon.bfs;

import java.util.*;
import java.io.*;

public class Main14503 {

    public static int solution(int n, int m, int x,int y, int d, int[][] arr) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if(arr[now[0]][now[1]] == 0) {
                arr[now[0]][now[1]] = 2;
                answer++;
            }
            boolean flag = false;
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                int index = (d <= 1) ? (d + 2) : (d - 2);
                int nx = now[0] + dx[index];
                int ny = now[1] + dy[index];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && (arr[nx][ny] == 0 || arr[nx][ny] == 2)) {
                    queue.offer(new int[]{nx, ny});
                } else {
                    queue.clear();
                    break;
                }
            } else {
                for(int i = 0; i < 4; i++) {
                    d = (d + 3) % 4;
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                        queue.offer(new int[]{nx, ny});
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n, m, x, y, d, arr));
    }
}
