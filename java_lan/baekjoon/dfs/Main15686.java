package java_lan.baekjoon.dfs;

import java.util.*;
import java.io.*;

public class Main15686 {

    static int answer;
    static int[] index;
    static List<int[]> chicken;
    static List<int[]> home;

    public static int distance() {
        int sum = 0;
        int[] cost = new int[home.size()];

        Arrays.fill(cost, Integer.MAX_VALUE);
        for(int i = 0; i < index.length; i++) {
            int[] c = chicken.get(index[i]);
            for(int j = 0; j < home.size(); j++) {
                int[] h = home.get(j);
                cost[j] = Math.min(cost[j], Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]));
            }
        }
        for(int i = 0; i < cost.length; i++) {
            sum += cost[i];
        }

        return sum;
    }

    public static void dfs(int level, int s) {
        if(level == index.length) {
            answer = Math.min(answer, distance());
            return;
        }
        for(int i = s; i < chicken.size(); i++) {
            index[level] = i;
            dfs(level + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][n];
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        for(int i = 0; i < graph.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < graph.length; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                } else if(graph[i][j] == 1) {
                    home.add(new int[]{i, j});
                }
            }
        }

        answer = Integer.MAX_VALUE;
        index = new int[m];
        dfs(0, 0);

        System.out.println(answer);
    }
}
