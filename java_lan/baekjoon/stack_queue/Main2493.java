package java_lan.baekjoon.stack_queue;

import java.util.*;
import java.io.*;

public class Main2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, arr[0]});
        for(int i = 1; i < n; i++) {
            while(!stack.isEmpty()) {
                int[] now = stack.pop();
                if(now[1] >= arr[i]) {
                    answer[i] = now[0] + 1;
                    stack.push(now);
                    break;
                }
            }
            stack.push(new int[]{i, arr[i]});
        }

        StringBuilder sb = new StringBuilder();
        for(int a: answer) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}
