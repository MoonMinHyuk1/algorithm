package java_lan.baekjoon.dfs;

import java.util.*;
import java.io.*;

public class Main2573 {
    static int answer = 0;
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void melt(int[][] l, int[][] visited) {
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                if(l[x][y] != 0) {
                    for(int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && l[nx][ny] == 0) {
                            visited[x][y]++;
                        }
                    }
                }
            }
        }
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                if(l[x][y] != 0) {
                    l[x][y] -= visited[x][y];
                    if(l[x][y] < 0) {
                        l[x][y] = 0;
                    }
                }
            }
        }
    }

    public static void search(int x, int y, int[][] l, int[][] visited) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && l[nx][ny] > 0 && visited[nx][ny] == 0) {
                visited[nx][ny] = 1;
                search(nx, ny, l, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] l = new int[n][m];
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");    
            for(int j = 0; j < m; j++) {
                l[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            answer++;
            visited = new int[n][m];
            melt(l, visited);
            visited = new int[n][m];
            int slice = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(l[i][j] > 0 && visited[i][j] == 0) {
                        visited[i][j] = 1;
                        search(i, j, l, visited);
                        slice++;
                    }
                }
            }
            if(slice > 1) {
                sb.append(answer);
                break;
            }
            else if(slice == 0) {
                sb.append(slice);
                break;
            }
        }

        System.out.println(sb);
    }
}
