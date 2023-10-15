package java_lan.baekjoon.dfs;

import java.util.*;
import java.io.*;

public class Main15649 {

    static boolean[] visited;
    static int[] arr;

    public static void dfs(int level, int n, int m) {
        if(level == m) {
            for(int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(!visited[i - 1]) {
                visited[i - 1] = true;
                arr[level] = i;
                dfs(level + 1, n, m);
                visited[i - 1] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        arr = new int[m];
        dfs(0, n, m);
    }
}
