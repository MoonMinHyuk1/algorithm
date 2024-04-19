package java_lan.baekjoon.stack_queue;

import java.util.*;
import java.io.*;

public class Main1021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[m];
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            deque.offerLast(i);
        }
        for(int i = 0; i < arr.length; i++) {
            int index = 0;
            for(int num: deque) {
                if(num == arr[i]) {
                    break;
                }
                index++;
            }
            if(index <= deque.size() / 2) {
                while(deque.peekFirst() != arr[i]) {
                    deque.offerLast(deque.pollFirst());
                    answer++;
                }
            } else {
                while(deque.peekFirst() != arr[i]) {
                    deque.offerFirst(deque.pollLast());
                    answer++;
                }
            }
            deque.pollFirst();
        }

        System.out.println(answer);
    }
}
