package java_lan.baekjoon.stack_queue;

import java.util.*;
import java.io.*;

public class Main5430 {

    static int order;
    static StringBuilder sb;

    public static void insert(Deque<Integer> deque, String str) {
        String[] nums = str.split(",");
        if(order == 0) {
            for(String num: nums) {
                deque.offerLast(Integer.parseInt(num));
            }
        } else {
            for(String num: nums) {
                deque.offerFirst(Integer.parseInt(num));
            }
        }
    }

    public static boolean operate(Deque<Integer> deque, String fun) {
        for(char c: fun.toCharArray()) {
            if(c == 'R') {
                order = (order == 0) ? 1 : 0;
            } else {
                if(deque.size() == 0) return false;
                if(order == 0) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }

        return true;
    }

    public static void print(Deque<Integer> deque) {
        int[] arr = new int[deque.size()];
        int index = 0;

        if(deque.isEmpty()) {
            sb.append("[]\n");
            return;
        }
        for(int num: deque) {
            arr[index++] = num;
        }
        if(order == 0) {
            sb.append("[");
            for(int i = 0; i < arr.length - 1; i++) {
                sb.append(arr[i] + ",");
            }
            sb.append(arr[arr.length - 1] + "]\n");
        } else {
            sb.append("[");
            for(int i = arr.length - 1; i > 0; i--) {
                sb.append(arr[i] + ",");
            }
            sb.append(arr[0] + "]\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int i = 0; i < t; i++) {
            String fun = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();

            order = 0;
            Deque<Integer> deque = new LinkedList<>();
            str = str.substring(1, str.length() - 1);
            //order 0 : 왼 -> 오, 1 : 오 -> 왼
            if(n != 0) insert(deque, str);
            if(operate(deque, fun)) {
                print(deque);
            } else {
                sb.append("error\n");
            }
        }

        System.out.println(sb);
    }
}
