package java_lan.baekjoon.graph;

import java.util.*;
import java.io.*;

public class Main2206 {

    public static int solution(int[][] arr, int n, int m) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        boolean[][][] visited = new boolean[n][m][2];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        pq.offer(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(now[0] == n - 1 && now[1] == m - 1) {
                return now[2];
            }
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(arr[nx][ny] == 0) {  //벽이 아닐 때
                        if(!visited[nx][ny][0] && now[3] == 0) {
                            visited[nx][ny][0] = true;
                            pq.offer(new int[]{nx, ny, now[2] + 1, 0});
                        }
                        if(!visited[nx][ny][1] && now[3] == 1) {
                            visited[nx][ny][1] = true;
                            pq.offer(new int[]{nx, ny, now[2] + 1, 1});
                        }
                    } else {                //벽일 때
                        if(!visited[nx][ny][1] && now[3] == 0) {
                            visited[nx][ny][1] = true;
                            pq.offer(new int[]{nx, ny, now[2] + 1, 1});
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                if(str.charAt(j) == '1') {
                    arr[i][j] = 1;
                }
            }
        }

        System.out.println(solution(arr, n, m));
    }
}
