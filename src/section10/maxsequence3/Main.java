package section10.maxsequence3;

import java.util.Scanner;

public class Main {
    static int[] arr, dp;
    static int n;

    public int solution() {
        int answer = 0;

        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i] && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        dp = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(A.solution());
    }
}
