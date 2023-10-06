package java_lan.baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][10];
        dp[1][0] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            for(int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10007;
            }
        }

        int answer = 0;
        for(int i = 0; i < 10; i++) {
            answer += (dp[n][i] * (10 - i));
        }
        System.out.println(answer % 10007);
    }
}
