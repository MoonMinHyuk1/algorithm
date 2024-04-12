package java_lan.baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Main14935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();

        String answer = "NFA";
        while(true) {
            int n = (x.charAt(0) - '0') * x.length();
            String s = String.valueOf(n);
            if(s.equals(x)) {
                answer = "FA";
                break;
            }
            x = s;
        }

        System.out.println(answer);
    }
}
