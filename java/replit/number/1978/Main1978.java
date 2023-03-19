import java.util.*;

public class Main1978 {
  public int isPrime(int n) {
    if(n == 1) return 0;
    for(int i = 2; i < n; i++) {
      if(n % i == 0) return 0;
    }

    return 1;
  }
  
  public static void main(String[] args) {
    Main1978 A = new Main1978();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int answer = 0;
    for(int i = 0; i < n; i++) {
      answer += A.isPrime(arr[i]);
    }
    System.out.println(answer);
  }
}