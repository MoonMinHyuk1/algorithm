package section10.coin5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] dp, arr;

    public void solution() {
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = arr[i]; j <= m; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        dp = new int[m + 1];
        A.solution();
        System.out.println(dp[m]);
    }
}
