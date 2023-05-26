package data_structure;

import java.util.*;

public class Main3_2 {

    public String solution(String s){
        String answer = "";
        Deque<String> deque = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                String tmp = "";
                while(!deque.peekLast().equals("(")) {
                    tmp = deque.pollLast() + tmp;
                }
                deque.pollLast(); //"("
                String str = tmp;
                if(!deque.isEmpty() && (deque.peekLast().charAt(0) >= '2' && deque.peekLast().charAt(0) <= '9')) {
                    int n = Integer.valueOf(deque.pollLast());
                    for(int j = 0; j < n - 1; j++) {
                        str += tmp;
                    }
                }
                deque.offer(str);
            } else {
                deque.offer(String.valueOf(s.charAt(i)));
            }
        }
        while(!deque.isEmpty()) {
            answer += deque.poll();
        }

        return answer;
    }

    public static void main(String[] args){
        Main3_2 T = new Main3_2();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
