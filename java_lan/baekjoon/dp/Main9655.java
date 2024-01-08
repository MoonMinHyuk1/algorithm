package java_lan.baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[n + 1];

        Arrays.fill(dp, true);
        if(n >= 2) dp[2] = false;
        for(int i = 4; i < dp.length; i++) {
            if(dp[i - 1] && dp[i - 3]) {
                dp[i] = false;
            }
        }

        System.out.println((dp[n]) ? "SK" : "CY");
    }
}
