package java_lan.baekjoon.stack_queue;

import java.util.*;
import java.io.*;

public class Main2504 {

    public static boolean collect(String str) {
        Stack<Character> stack = new Stack<>();

        for(char c: str.toCharArray()) {
            if(c == '(' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                if(c == ')') {
                    if(stack.pop() != '(') {
                        return false;
                    }
                } else if(c == ']') {
                    if(stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static int solution(String str) {
        if(!collect(str)) {
            return 0;
        }
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        //-1 : (, -2 : ), -3 : [, -4 : ]

        for(char c: str.toCharArray()) {
            if(c == '(') {
                stack.push(-1);
            } else if(c == '[') {
                stack.push(-3);
            } else if(c == ')') {
                int score = 0;
                while(true) {
                    int s = stack.pop();
                    if(s == -1) {
                        break;
                    } else {
                        score += s;
                    }
                }
                score = (score == 0) ? 1 : score;
                stack.push(score * 2);
            } else if(c == ']') {
                int score = 0;
                while(true) {
                    int s = stack.pop();
                    if(s == -3) {
                        break;
                    } else {
                        score += s;
                    }
                }
                score = (score == 0) ? 1 : score;
                stack.push(score * 3);
            }
        }
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution(str));
    }
}
