package java_lan.baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Main1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();

        int s = k;
        StringBuilder sb = new StringBuilder();
        set.add(s);
        sb.append("<").append(s);
        for(int i = 0; i < n - 1; i++) {
            int len = 0;
            while(len < k) {
                s = s % n + 1;
                if(!set.contains(s)) {
                    len++;
                }
            }
            set.add(s);
            sb.append(", ").append(s);
        }
        sb.append(">");
        System.out.println(sb);
    }
}
