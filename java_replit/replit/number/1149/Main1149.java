import java.util.*;

public class Main1149 {
  static int[][] arr, dp;
  static int n;

  public int solution() {
    int answer = 0;

    for(int i = 0; i < 3; i++) {
      dp[0][i] = arr[0][i];
    }
    for(int i = 1; i < n; i++) {
      dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
      dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
      dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
    }
    answer = Math.min(dp[n - 1][0], dp[n - 1][1]);
    answer = Math.min(answer, dp[n - 1][2]);

    return answer;
  }
  
  public static void main(String[] args) {
    Main1149 A = new Main1149();
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    arr = new int[n][3];
    dp = new int[n][3];
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < 3; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    System.out.println(A.solution());
  }
}