package java_lan.baekjoon.mathematics;

import java.util.*;
import java.io.*;

public class Main1929 {

    public static boolean isPrime(int n) {
        if(n == 1) return false;

        int sqrt = (int) Math.sqrt(n);
        for(int i = 2; i <= sqrt; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i = n; i <= m; i++) {
            if(isPrime(i)) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
