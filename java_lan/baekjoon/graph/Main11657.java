package java_lan.baekjoon.graph;

import java.util.*;
import java.io.*;

public class Main11657 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<int[]> edge = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            edge.add(new int[]{a, b, c});
        }

        long[] cost = new long[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int[] now = edge.get(j);
                int a = now[0], b = now[1], c = now[2];
                if(cost[a] != Integer.MAX_VALUE && cost[a] + c < cost[b]) {
                    cost[b] = cost[a] + c;
                }
            }
        }
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int[] now = edge.get(i);
            int a = now[0], b = now[1], c = now[2];
            if(cost[a] != Integer.MAX_VALUE && cost[a] + c < cost[b]) {
                sb.append(-1);
                flag = false;
                break;
            }
        }
        if(flag) {
            for(int i = 1; i < cost.length; i++) {
                if(cost[i] == Integer.MAX_VALUE) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(cost[i]).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}
