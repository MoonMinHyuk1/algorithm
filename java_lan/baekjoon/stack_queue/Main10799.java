package java_lan.baekjoon.stack_queue;

import java.util.*;
import java.io.*;

public class Main10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                stack.push('(');
            } else {
                if(str.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
