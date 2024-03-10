package java_lan.baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class Main1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 1, num = 666;
        while(true) {
            if(n == cnt) break;
            num++;
            if(String.valueOf(num).contains("666")) {
                cnt++;
            }
        }

        System.out.println(num);
    }
}
