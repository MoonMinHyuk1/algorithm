package java_lan.baekjoon.stack_queue;

import java.util.*;
import java.io.*;

public class Main9012 {

    public static String solution(String str) {
        Stack<Character> stack = new Stack<>();

        for(char c: str.toCharArray()) {
            if(c == '(') stack.push(c);
            if(c == ')') {
                if(stack.isEmpty()) return "NO";
                if(stack.pop() != '(') return "NO";
            }
        }
        if(!stack.isEmpty()) return "NO";

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            sb.append(solution(str)).append("\n");
        }

        System.out.println(sb);
    }
}
