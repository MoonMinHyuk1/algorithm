package java_lan.baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int[] dp = new int[n + 1];
        for(int i = 0; i < arr.length; i++) {
            dp[i + 1] = arr[i];
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i]) {
                    dp[i + 1] = Math.max(dp[i + 1], dp[j + 1] + arr[i]);
                }
            }
            answer = Math.max(answer, dp[i + 1]);
        }
        System.out.println(answer);
    }
}
