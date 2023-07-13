package dp;

import java.io.*;

public class Main9_6 {

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum[i] = arr[i] + sum[i - 1];
            dp[i][i] = arr[i];
        }
        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j < arr.length - i; j++) {
                dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]) + (sum[j + i] - sum[j - 1]);
            }
        }

        System.out.println(dp[1][n]);
    }
}
