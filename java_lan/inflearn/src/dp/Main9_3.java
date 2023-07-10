package dp;

import java.io.*;

public class Main9_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n + 2];
        dp[2] = arr[0];
        for(int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 3]) + arr[i - 2];
        }

        System.out.println(dp[n + 1]);
    }
}
