package java_lan.baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[k + 1];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, 100000);
        dp[0] = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = arr[i]; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        System.out.println((dp[k] == 100000) ? -1 : dp[k]);
    }
}
