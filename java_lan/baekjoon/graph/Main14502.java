package java_lan.baekjoon.graph;

import java.util.*;
import java.io.*;

public class Main14502 {

    static int answer;

    public static void bfs(int n, int m, int[][] graph) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[][] arr = new int[graph.length][graph[0].length];
        int sum = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                arr[i][j] = graph[i][j];
                if(arr[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                    arr[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 0) {
                    sum++;
                }
            }
        }

        answer = Math.max(answer, sum);
    }

    public static void dfs(int level, int n, int m, int[][] graph) {
        if(level == 3) {
            bfs(n, m, graph);
            return;
        }
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                if(graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(level + 1, n, m, graph);
                    graph[i][j] = 0;
                }
            }
        }
    }

    public static void solution(int n, int m, int[][] graph) {
        dfs(0, n, m, graph);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][m];
        for(int i = 0; i < graph.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        solution(n, m, graph);

        System.out.println(answer);
    }
}
