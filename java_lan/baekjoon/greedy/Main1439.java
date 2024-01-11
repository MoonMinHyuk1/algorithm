package java_lan.baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Main1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = 1;
        char c = str.charAt(0);
        for(int i = 1; i < str.length(); i++) {
            if(c != str.charAt(i)) {
                c = str.charAt(i);
                n++;
            }
        }
        int answer = n / 2;

        System.out.println(answer);
    }
}
