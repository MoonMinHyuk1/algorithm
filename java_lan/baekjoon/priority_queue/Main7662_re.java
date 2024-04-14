package java_lan.baekjoon.priority_queue;

import java.util.*;
import java.io.*;

public class Main7662_re {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while(k-- > 0) {
                String str = br.readLine();
                String[] arr = str.split(" ");
                int num = Integer.parseInt(arr[1]);
                if(arr[0].equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if(arr[0].equals("D")) {
                    if(map.isEmpty()) continue;
                    int key = (num == 1) ? map.lastKey() : map.firstKey();
                    map.put(key, map.get(key) - 1);
                    if(map.get(key) == 0) {
                        map.remove(key);
                    }
                }
            }
            if(map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                int min = map.firstKey();
                int max = map.lastKey();
                sb.append(max).append(" ").append(min).append("\n");
            }
        }

        System.out.println(sb);
    }
}
