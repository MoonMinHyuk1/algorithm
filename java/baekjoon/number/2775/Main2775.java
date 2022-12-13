import java.util.*;

public class Main2775 {
  public static void main(String[] args) {
    Main2775 A = new Main2775();
    Scanner sc = new Scanner(System.in);

    int[][] dp = new int[15][15];
    for(int i = 0; i < 15; i++) {
      dp[0][i] = i;
      dp[i][1] = 1;
    }
    for(int i = 1; i < 15; i++) {
      for(int j = 2; j < 15; j++) {
        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
      }
    }
    
    int t = sc.nextInt();
    for(int i = 0; i < t; i++) {
      int k = sc.nextInt();
      int n = sc.nextInt();
      System.out.println(dp[k][n]);
    }
  }
}