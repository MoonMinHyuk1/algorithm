package java_lan.baekjoon.bfs;

import java.util.*;
import java.io.*;

public class Main7569 {

    public static boolean check(int h, int n, int m, int[][][] arr) {
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(arr[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static int solution(int h, int n, int m, int[][][] arr) {
        int answer = -1;
        boolean[][][] visited = new boolean[h][n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[] dh = {0, 0, 0, 0, 1, -1};
        int[] dn = {1, -1, 0, 0, 0, 0};
        int[] dm = {0, 0, 1, -1, 0, 0};

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(arr[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for(int j = 0; j < 6; j++) {
                    int nh = now[0] + dh[j];
                    int nn = now[1] + dn[j];
                    int nm = now[2] + dm[j];
                    if(nh >= 0 && nh < h && nn >= 0 && nn < n && nm >= 0 && nm < m && !visited[nh][nn][nm] && arr[nh][nn][nm] == 0) {
                        arr[nh][nn][nm] = 1;
                        visited[nh][nn][nm] = true;
                        queue.offer(new int[]{nh, nn, nm});
                    }
                }
            }
            answer++;
        }

        return (check(h, n, m, arr)) ? answer : -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] arr = new int[h][n][m];

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        System.out.println(solution(h, n, m, arr));
    }
}
