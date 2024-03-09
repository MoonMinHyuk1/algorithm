package java_lan.baekjoon.priority_queue;

import java.util.*;
import java.io.*;

public class Main11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                int num = 0;
                if(!pq.isEmpty()) {
                    num = pq.poll();
                }
                sb.append(num).append("\n");
            } else {
                pq.offer(x);
            }
        }

        System.out.println(sb);
    }
}
