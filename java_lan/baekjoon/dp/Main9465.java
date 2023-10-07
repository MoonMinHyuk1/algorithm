package java_lan.baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main9465 {

    public static int solution(int n, int[][] arr) {
        int answer = 0;
        int[][] dp = new int[2][n + 2];

        for(int i = 0; i < arr[0].length; i++) {
            dp[0][i + 2] = Math.max(dp[1][i + 1], dp[1][i]) + arr[0][i];
            dp[1][i + 2] = Math.max(dp[0][i + 1], dp[0][i]) + arr[1][i];
        }
        answer = Math.max(dp[0][n + 1], dp[1][n + 1]);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            for(int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(solution(n, arr));
        }
    }
}
