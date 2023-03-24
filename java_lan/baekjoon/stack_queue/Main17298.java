package java_lan.baekjoon.stack_queue;

import java.util.*;
import java.io.*;

public class Main17298 {
    public static void solution(int n, int[] l) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && l[i] > l[stack.peek()]) {
                l[stack.peek()] = l[i];
                stack.pop();
            }
            stack.add(i);
        }
        while(!stack.isEmpty()) {
            l[stack.pop()] = -1;
        }

        for(int i = 0; i < n; i++) {
            sb.append(l[i] + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] l = new int[n];
        for(int i = 0; i < n; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }
        solution(n, l);
    }
}
