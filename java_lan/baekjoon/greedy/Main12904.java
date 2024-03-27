package java_lan.baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Main12904 {

    public static int solution(String s, String t) {
        int answer = 0;

        while(s.length() < t.length()) {
            if(t.endsWith("A")) {
                t = t.substring(0, t.length() - 1);
            } else if(t.endsWith("B")) {
                t = t.substring(0, t.length() - 1);
                t = new StringBuilder(t).reverse().toString();
            }
        }
        if(s.equals(t)) {
            answer = 1;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        System.out.println(solution(s, t));
    }
}
