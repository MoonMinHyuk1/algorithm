package java_lan.baekjoon.stack_queue;

import java.util.*;
import java.io.*;

public class Main2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = n; i >= 1; i--) {
            deque.offerFirst(i);
        }
        while(deque.size() > 1) {
            deque.pollFirst();
            deque.offerLast(deque.pollFirst());
        }

        System.out.println(deque.poll());
    }
}
