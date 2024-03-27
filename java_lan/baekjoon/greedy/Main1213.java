package java_lan.baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Main1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String answer = "";
        Map<Character, Integer> map = new TreeMap<>();
        for(char c: str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int cnt = 0;
        char c = '1';
        for(char key: map.keySet()) {
            if(map.get(key) % 2 == 1) {
                c = key;
                cnt++;
            }
        }
        if(cnt >= 2) {
            answer = "I'm Sorry Hansoo";
        } else {
            for(char key: map.keySet()) {
                int value = map.get(key) / 2;
                for(int i = 0; i < value; i++) {
                    answer += key;
                }
            }
            String reverse = new StringBuilder(answer).reverse().toString();
            if(cnt == 1) {
                answer += c;
            }
            answer += reverse;
        }

        System.out.println(answer);
    }
}
