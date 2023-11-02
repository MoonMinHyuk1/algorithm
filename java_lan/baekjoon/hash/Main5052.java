package java_lan.baekjoon.hash;

import java.util.*;
import java.io.*;

public class Main5052 {

    public static String solution(String[] arr) {
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i].startsWith(arr[i - 1])) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for(int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }
            sb.append(solution(arr)).append("\n");
        }

        System.out.println(sb);
    }
}
