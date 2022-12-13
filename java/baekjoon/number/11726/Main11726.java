import java.util.*;

public class Main11726 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int[] dp = new int[1000];
    dp[0] = 1;
    dp[1] = 2;
    for(int i = 2; i < 1000; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
    }
    int n = sc.nextInt();
    System.out.println(dp[n - 1]);
  }
}