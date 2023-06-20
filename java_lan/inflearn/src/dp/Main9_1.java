package dp;

import java.util.*;
import java.io.*;

public class Main9_1 {

    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        int[] dp = new int[m + 1];

        for(int i = 0; i < n; i++) {
            for(int j = arr[i][1]; j <= m; j++) {
                if(dp[j - arr[i][1]] + arr[i][0] > dp[j]) {
                    dp[j] = dp[j - arr[i][1]] + arr[i][0];
                }
            }
        }
        for(int i = 0; i < dp.length; i++) {
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main9_1 T = new Main9_1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
            if(n == 0 && m == 0) {
                break;
            }
            arr = new int[n][2];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
            }
            System.out.println(T.solution(n, m, arr));
        }
    }
}
