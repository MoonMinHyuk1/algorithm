package section10.maxscore6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int dp[] = new int[m + 1];
        for(int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            for(int j = m; j >= time; j--) {
                dp[j] = Math.max(dp[j], dp[j - time] + score);
            }
        }

        System.out.println(dp[m]);
    }
}
