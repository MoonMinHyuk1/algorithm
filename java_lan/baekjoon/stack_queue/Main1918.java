package java_lan.baekjoon.stack_queue;

import java.util.*;
import java.io.*;

public class Main1918 {
    public static String solution(String str) {
        String answer = "";
        Deque<Character> deque = new ArrayDeque<>();

        char[] c = str.toCharArray();
        for(int i = 0; i < c.length; i++) {
            if(c[i] == '+' || c[i] == '-') {
                while(!deque.isEmpty() && (deque.peekLast() == '+' || deque.peekLast() == '-' || deque.peekLast() == '*' || deque.peekLast() == '/')) {
                    answer += deque.pollLast();
                }
                deque.offer(c[i]);
            } else if(c[i] == '*' || c[i] == '/') {
                while(!deque.isEmpty() && (deque.peekLast() == '*' || deque.peekLast() == '/')) {
                    answer += deque.pollLast();
                }
                deque.offer(c[i]);
            } else if(c[i] == '(') {
                deque.offer(c[i]);
            } else if(c[i] == ')') {
                while(!deque.isEmpty() && deque.peekLast() != '(') {
                    answer += deque.pollLast();
                }
                deque.pollLast();
            } else {
                answer += c[i];
            }
        }
        while(!deque.isEmpty()) {
            answer += deque.pollLast();
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        sb.append(solution(str));
        System.out.println(sb);
    }
}
