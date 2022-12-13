import java.util.*;

public class Main2748 {
  static long[] fibo;

  public long DFS(int n) {
    if(fibo[n] > 0) {
      return fibo[n];
    }
    if(n == 1) {
      return fibo[n] = 1;
    } else if(n == 2) {
      return fibo[n] = 1;
    } else {
      return fibo[n] = DFS(n - 1) + DFS(n - 2);
    }
  }
  
  public static void main(String[] args) {
    Main2748 A = new Main2748();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    fibo = new long[n + 1];
    A.DFS(n);
    System.out.println(fibo[n]);
  }
}