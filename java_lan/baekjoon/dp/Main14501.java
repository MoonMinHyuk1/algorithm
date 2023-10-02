package java_lan.baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main14501 {

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1]; //해당 일에 얻을 수 있는 최대 수익

        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i + arr[i][0] <= arr.length) {
                dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], max + arr[i][1]);
            }
            max = Math.max(max, dp[i + 1]);
        }
        for(int i = 0; i < dp.length; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
