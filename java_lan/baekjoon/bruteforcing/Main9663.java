package java_lan.baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class Main9663 {
    static int n, answer;
    static int[] indexs;

    public static boolean ch(int index) {
        for(int i = 0; i < index; i++) {
            if(indexs[i] == indexs[index]) {
                return false;
            }
            if(Math.abs(i - index) == Math.abs(indexs[i] - indexs[index])) {
                return false;
            }
        }

        return true;
    }

    public static void solution(int level) {
        if(level == n - 1) {
            for(int i = 0; i < n; i++) {
                indexs[level] = i;
                if(ch(level)) {
                    answer++;
                }
            }
            return;
        }
        for(int i = 0; i < n; i++) {
            indexs[level] = i;
            if(ch(level)) {
                solution(level + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        indexs = new int[n];
        answer = 0;
        solution(0);

        System.out.println(answer);
    }
}
