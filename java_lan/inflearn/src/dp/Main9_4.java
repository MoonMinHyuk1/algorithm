package dp;

import java.util.*;
import java.io.*;

public class Main9_4 {

    public static void main(String[] args) throws IOException {
        int answer = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for(int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int d = arr[j] - arr[i];
                for(int k = i - 1; k > 0; k--) {
                    if(d == arr[i] - arr[k]) {
                        dp[i][j] = dp[k][i] + 1;
                        break;
                    } else if(d < arr[i] - arr[k]) {
                        break;
                    }
                }
                if(dp[i][j] == 0) {
                    dp[i][j] = 2;
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}
