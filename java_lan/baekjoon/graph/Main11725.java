package java_lan.baekjoon.graph;

import java.util.*;
import java.io.*;

public class Main11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] answer = new int[n - 1];

        Arrays.fill(answer, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()) {
            int v = queue.poll();
            for(int nv: graph.get(v)) {
                if(nv != 0 && answer[nv - 1] == -1) {
                    answer[nv - 1] = v + 1;
                    queue.offer(nv);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num: answer) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}
