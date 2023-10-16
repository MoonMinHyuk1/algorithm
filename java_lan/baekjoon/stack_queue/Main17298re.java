package java_lan.baekjoon.stack_queue;

import java.util.*;
import java.io.*;

public class Main17298re {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && stack.peek()[1] < arr[i]) {
                answer[stack.pop()[0]] = arr[i];
            }
            stack.push(new int[]{i, arr[i]});
        }
        while(!stack.isEmpty()) {
            answer[stack.pop()[0]] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.length; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}
