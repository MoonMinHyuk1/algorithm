package java_lan.baekjoon.dfs;

import java.util.*;
import java.io.*;

public class Main13023 {

    static int answer;

    public static void dfs(List<List<Integer>> graph, boolean[] visited, int v, int cnt) {
        if(cnt == 5) {
            answer = 1;
            return;
        }
        for(int nv: graph.get(v)) {
            if(!visited[nv]) {
                visited[nv] = true;
                dfs(graph, visited, nv, cnt + 1);
                visited[nv] = false;
            }
        }
    }

    public static int solution(int n, List<List<Integer>> graph) {
        answer = 0;
        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            dfs(graph, visited, i, 1);
            if(answer == 1) break;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(solution(n, graph));
    }
}
