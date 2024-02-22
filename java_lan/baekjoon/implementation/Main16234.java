package java_lan.baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Main16234 {

    public static boolean move(int n, int l, int r, int[][] arr, int i, int j, boolean[][] visited) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        List<int[]> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        list.add(new int[]{i, j});
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int sub = Math.abs(arr[x][y] - arr[nx][ny]);
                    if(sub >= l && sub <= r) {
                        list.add(new int[]{nx, ny});
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        int sum = 0;
        for(int[] index: list) {
            sum += arr[index[0]][index[1]];
        }
        for(int[] index: list) {
            arr[index[0]][index[1]] = (sum / list.size());
        }

        return (list.size() == 1) ? false : true;
    }

    public static int solution(int n, int l, int r, int[][] arr) {
        int answer = 0;

        while(true) {
            boolean[][] visited = new boolean[n][n];
            boolean flag = false;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]) {
                        if (flag) {
                            move(n, l, r, arr, i, j, visited);
                        } else {
                            flag = move(n, l, r, arr, i, j, visited);
                        }
                    }
                }
            }
            if(!flag) {
                break;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n, l, r, arr));
    }
}
