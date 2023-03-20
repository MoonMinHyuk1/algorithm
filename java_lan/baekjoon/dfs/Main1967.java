package java_lan.baekjoon.dfs;

import java.util.*;
import java.io.*;

public class Main1967 {
    static class Node {
        int v, e;
        public Node(int v, int e) {
            this.v = v;
            this.e = e;
        }
    }

    static int n, answer = 0;
    static List<Node>[] tree;
    static boolean[] visited;

    public static void dfs(int v, int len) {
        for(Node node: tree[v]) {
            if(!visited[node.v]) {
                visited[node.v] = true;
                dfs(node.v, len + node.e);
            }
        }

        answer = (answer < len) ? len : answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree[a].add(new Node(b, w));
            tree[b].add(new Node(a, w));
        }

        for(int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, 0);
        }

        sb.append(answer);
        System.out.println(sb);
    }
}
