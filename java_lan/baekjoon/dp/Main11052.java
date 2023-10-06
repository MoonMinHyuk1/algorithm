package java_lan.baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1]; //해당 개수에 지불할 수 있는 최대 금액

        dp[1] = arr[0];
        for(int i = 2; i < dp.length; i++) {
            dp[i] = arr[i - 1];
            for(int j = i - 1; j >= 1; j--) {
                dp[i] = Math.max(dp[i], dp[j] + arr[i - j - 1]);
            }
        }

        System.out.println(dp[n]);
    }
}
