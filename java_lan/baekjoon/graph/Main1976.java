package java_lan.baekjoon.graph;

import java.util.*;
import java.io.*;

public class Main1976 {

    static int[] parent;

    public static int find(int n) {
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return;

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        int[] arr = new int[m];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        String answer = "YES";
        parent = new int[n];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(graph[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int p = parent[arr[0]];
        for(int i = 1; i < arr.length; i++) {
            if(p != parent[arr[i]]) {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
    }
}
