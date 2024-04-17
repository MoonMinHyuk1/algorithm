package java_lan.baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Main20040 {

    public static int find(int[] parent, int a) {
        if(a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent, parent[a]);
    }

    public static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if(a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(answer != 0) continue;
            if(find(parent, a) == find(parent, b)) {
                answer = i;
            } else {
                union(parent, a, b);
            }
        }

        System.out.println(answer);
    }
}
