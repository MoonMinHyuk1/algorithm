package java_lan.baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Main1834 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long answer = 0;
        for(long i = 1; i < n; i++) {
            answer += ((n * i) + i);
        }

        System.out.println(answer);
    }
}
