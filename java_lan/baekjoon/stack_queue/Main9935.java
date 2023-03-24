package java_lan.baekjoon.stack_queue;

import java.util.*;
import java.io.*;

public class Main9935 {
    public static void solution(String str, String bomb) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= bomb.length()) {
                boolean ch = true;
                for(int j = 1; j <= bomb.length(); j++) {
                    if(stack.get(stack.size() - j) != bomb.charAt(bomb.length() - j)) {
                        ch = false;
                        break;
                    }
                }
                if(ch) {
                    for(int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        for(Character c : stack) {
            sb.append(c);
        }
        if(stack.isEmpty()) {
            sb.append("FRULA");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        solution(str, bomb);
    }
}
