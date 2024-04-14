package java_lan.baekjoon.priority_queue;

import java.util.*;
import java.io.*;

public class Main7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            while(k-- > 0) {
                String str = br.readLine();
                String[] arr = str.split(" ");
                int num = Integer.parseInt(arr[1]);
                if(arr[0].equals("I")) {
                    min.offer(num);
                    max.offer(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if(arr[0].equals("D")) {
                    if(num == 1) {
                        if(map.isEmpty()) continue;
                        while(true) {
                            int key = max.poll();
                            if(map.get(key) == null) continue;
                            map.put(key, map.get(key) - 1);
                            if(map.get(key) == 0) {
                                map.remove(key);
                            }
                            break;
                        }
                    } else if(num == -1) {
                        if(map.isEmpty()) continue;
                        while(true) {
                            int key = min.poll();
                            if(map.get(key) == null) continue;
                            map.put(key, map.get(key) - 1);
                            if(map.get(key) == 0) {
                                map.remove(key);
                            }
                            break;
                        }
                    }
                }
            }
            if(map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                while(true) {
                    int key = max.poll();
                    if(map.get(key) == null) continue;
                    sb.append(key).append(" ");
                    break;
                }
                while(true) {
                    int key = min.poll();
                    if(map.get(key) == null) continue;
                    sb.append(key).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
