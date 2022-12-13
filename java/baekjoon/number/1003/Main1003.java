import java.util.*;

public class Main1003 {
  static int[][] arr;

  public void DFS(int n) {
    if(n == 0) {
      if(arr[n][0] == 0) {
        arr[n][0]++;
      }
    } else if(n == 1) {
      if(arr[n][1] == 0) {
        arr[n][1]++;
      }
    } else {
      if(arr[n][0] == 0 || arr[n][1] == 0) {
        DFS(n - 1);
        DFS(n - 2);
        arr[n][0] = arr[n - 1][0] + arr[n - 2][0];
        arr[n][1] = arr[n - 1][1] + arr[n - 2][1];
      }
    }
  }

  public static void main(String[] args) {
    Main1003 A = new Main1003();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    arr = new int[41][2];
    for(int i = 0; i < n; i++) {
      int num = sc.nextInt();
      A.DFS(num);
      System.out.println(arr[num][0] + " " + arr[num][1]);
    }
  }
}