package java_lan.baekjoon.priority_queue;

import java.util.*;
import java.io.*;

public class Main1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> max = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(min.size() == max.size()) {
                min.offer(num);
            } else {
                max.offer(num);
            }

            if(!min.isEmpty() && !max.isEmpty() && min.peek() > max.peek()) {
                int temp = min.poll();
                min.offer(max.poll());
                max.offer(temp);
            }
            sb.append(min.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
