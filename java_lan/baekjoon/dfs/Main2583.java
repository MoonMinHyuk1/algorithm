package java_lan.baekjoon.dfs;

import java.util.*;
import java.io.*;

public class Main2583 {

    static List<Integer> list;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int sum;

    public static void dfs(int[][] graph, int x, int y) {
        sum++;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < graph.length && ny >= 0 && ny < graph[0].length && graph[nx][ny] == 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(graph, nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] graph = new int[m][n];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int j = x1; j < x2; j++) {
                for(int l = y1; l < y2; l++) {
                    graph[j][l] = 1;
                }
            }
        }

        list = new ArrayList<>();
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(graph[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    sum = 0;
                    dfs(graph, i, j);
                    list.add(sum);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size() + "\n");
        Collections.sort(list);
        for(int num: list) {
            sb.append(num + " ");
        }
        System.out.println(sb);
    }
}