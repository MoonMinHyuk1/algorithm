import java.util.*;

public class Main1026 {
  static int n, answer = 0;
  static Integer[] A, B;

  public void solution() {
    Arrays.sort(A);
    Arrays.sort(B, Collections.reverseOrder());

    for(int i = 0; i < n; i++) {
      answer += A[i] * B[i];
    }
  }
  
  public static void main(String[] args) {
    Main1026 C = new Main1026();
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    A = new Integer[n];
    B = new Integer[n];
    for(int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    for(int i = 0; i < n; i++) {
      B[i] = sc.nextInt();
    }
    C.solution();
    System.out.println(answer);
  }
}