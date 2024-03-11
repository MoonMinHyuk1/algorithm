package java_lan.baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main11051 {

    public static int solution(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        for(int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
            if(i < k + 1) {
                dp[i][i] = 1;
            }
        }
        for(int i = 2; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % 10007;
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        k = Math.min(k, n - k);

        int answer = 1;
        if(0 < k && k < n) {
            answer = solution(n, k);
        }

        System.out.println(answer);
    }
}
