package java_lan.baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main1010 {

    public static long solution(int n, int m) {
        long answer = 1;

        n = Math.min(n, m - n);
        for(int i = 0; i < n; i++) {
            answer *= (m - i);
            answer /= (i + 1);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            System.out.println(solution(n, m));
        }
    }
}
