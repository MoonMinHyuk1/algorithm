package java_lan.baekjoon.stack_queue;

import java.util.*;
import java.io.*;

public class Main4949 {

    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            if(c == '(' || c == '[') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty() || (!stack.isEmpty() && stack.pop() != '(')) {
                    return "no";
                }
            } else if(c == ']') {
                if(stack.isEmpty() || (!stack.isEmpty() && stack.pop() != '[')) {
                    return "no";
                }
            }
        }
        if(!stack.isEmpty()) {
            return "no";
        }

        return "yes";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String s = br.readLine();
            if(s.equals(".")) break;
            sb.append(solution(s) + "\n");
        }
        System.out.println(sb);
    }
}
