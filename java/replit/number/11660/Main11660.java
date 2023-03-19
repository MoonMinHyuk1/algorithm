import java.util.*;

class Main11660 {
  public int[] solution(int n, int m, int[][] arr1, int[][] arr2) {
    int[] answer = new int[m];
    int[][] dp = new int[n + 1][n + 1];

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        dp[i + 1][j + 1] = dp[i + 1][j] + arr1[i][j];
      }
    }
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        dp[i + 1][j + 1] += dp[i][j + 1];
      }
    }
    
    for(int i = 0; i < m; i++) {
      int sum = 0;
      int x1 = arr2[i][0];
      int y1 = arr2[i][1];
      int x2 = arr2[i][2];
      int y2 = arr2[i][3];
      sum = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
      answer[i] = sum;
    }

    return answer;
  }

  public static void main(String[] args) {
    Main11660 A = new Main11660();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] arr1 = new int[n][n];
    int[][] arr2 = new int[m][4];
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        arr1[i][j] = sc.nextInt();
      }
    }
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < 4; j++) {
        arr2[i][j] = sc.nextInt();
      }
    }
    for(int num : A.solution(n, m, arr1, arr2)) {
      System.out.println(num);
    }
  }
}