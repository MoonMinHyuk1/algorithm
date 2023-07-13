package dp;

import java.util.*;
import java.io.*;

public class Main9_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n + 1];
        for(int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][]dp = new int[n + 1][n + 1];
        //dp[i][j] -> i ~ j 부분 수열에서 팰린드롬을 만드는데 필요한 최소 개수
        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j < arr.length - i; j++) {
                if(arr[j] == arr[j + i]) {
                    dp[j][j + i] = dp[j + 1][j + i - 1];
                } else {
                    dp[j][j + i] = Math.min(dp[j][j + i - 1], dp[j + 1][j + i]) + 1;
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}
