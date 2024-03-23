package java_lan.baekjoon.mathematics;

import java.util.*;
import java.io.*;

public class Main4948 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                break;
            }
            list.add(n);
            max = Math.max(max, n);
        }

        boolean[] arr = new boolean[(max * 2) + 1];
        for(int i = 2; i < arr.length; i++) {
            arr[i] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < arr.length; i++) {
            if(arr[i]) {
                for(int j = i + i; j < arr.length; j += i) {
                    arr[j] = false;
                }
            }
        }
        for(int n: list) {
            int cnt = 0;
            for(int i = n + 1; i <= 2 * n; i++) {
                if(arr[i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
