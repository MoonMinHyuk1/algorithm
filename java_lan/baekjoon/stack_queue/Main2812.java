package java_lan.baekjoon.stack_queue;

import java.util.*;
import java.io.*;

public class Main2812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            while(!deque.isEmpty() && deque.peekLast() < num && k > 0) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(num);
        }
        for(int i = 0; i < k; i++) {
            deque.pollLast();
        }
        while(!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        System.out.println(sb);
    }
}
