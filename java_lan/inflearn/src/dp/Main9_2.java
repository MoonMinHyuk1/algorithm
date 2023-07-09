package dp;

import java.util.*;
import java.io.*;

public class Main9_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        int[] dp = new int[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] == o2[0]) ? (o2[1] - o1[1]) : (o1[0] - o2[0]);
            }
        });
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = n; j >= arr[i][0]; j--) {
                dp[j] = Math.max(Math.min(arr[i][1], dp[j - arr[i][0]]), dp[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
