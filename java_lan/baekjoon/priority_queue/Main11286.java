package java_lan.baekjoon.priority_queue;

import java.util.*;
import java.io.*;

public class Main11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    int num = pq.poll();
                    if(map.containsKey(num * -1) && map.get(num * -1) > 0) {
                        num *= -1;
                    }
                    map.put(num, map.get(num) - 1);
                    sb.append(num).append("\n");
                }
            } else {
                pq.offer(Math.abs(x));
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }

        System.out.println(sb);
    }
}
